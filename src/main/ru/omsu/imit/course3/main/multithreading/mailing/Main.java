package ru.omsu.imit.course3.main.multithreading.mailing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void sender(String filePath){
        String message = "Eat more of these soft French buns";

        Thread thread1 = new Thread(()->{
            for(int i = 0; i < 10; i++){
                String email = null;
                try {
                    email = readEmail(filePath);
                } catch (java.io.IOException e) {

                }
                Message message1 = new Message(email, "thread1", "mails.files", message);
                try {
                    Transport.send(message1);
                } catch (TransportException e) { }
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i = 0; i < 10; i++){
                String email = null;
                try {
                    email = readEmail(filePath);
                } catch (java.io.IOException e) {

                }

                Message message2 = new Message(email, "thread2", "mails.files", message);
                try {
                    Transport.send(message2);
                } catch (TransportException e) { }
            }
        });

        thread1.start();
        thread2.start();
    }

    public static String readEmail(String filePath) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            synchronized (br) {
                String str = br.readLine();
                System.out.println(str);
                return str;
            }
        }catch(FileNotFoundException ffe){
            throw new FileNotFoundException("");
        }
    }
    public static void main(String[] args) {
        sender("src//main//ru//omsu//imit//course3//main//multithreading//mailing//mails.txt");
    }
}

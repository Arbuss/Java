package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.Arrays;

public class Executors extends Thread{
    private DataQueue queue;

    public Executors(DataQueue queue){
        this.queue = queue;
    }

    public Data read() throws InterruptedException {
        return queue.take();
    }

    public void run(){
        try (BufferedOutputStream bos = new BufferedOutputStream(System.out)) {
            while (true) {
                try {
                    byte[] bytes = Arrays.toString(read().get()).getBytes();
                    bos.write(bytes);

                }
                catch(BufferOverflowException e){
                    bos.flush();
                }
                catch (InterruptedException e) {

                }
            }
        } catch (IOException e) {

        }
    }
}

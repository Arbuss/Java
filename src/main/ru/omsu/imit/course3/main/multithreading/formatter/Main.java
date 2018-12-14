package ru.omsu.imit.course3.main.multithreading.formatter;

import java.util.Date;

public class Main {
    public static void formatter(){
        Formatter formatter = new Formatter();
        Date date = new Date();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1: " + formatter.format(date));
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2: " + formatter.format(date));
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("Thread3: " + formatter.format(date));
        });

        Thread thread4 = new Thread(() -> {
            System.out.println("Thread4: " + formatter.format(date));
        });

        Thread thread5 = new Thread(() -> {
            System.out.println("Thread5: " + formatter.format(date));
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public static void main(String[] args) {
        formatter();
    }
}

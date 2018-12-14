package ru.omsu.imit.course3.main.multithreading.threads.eleventh.task.threads;

public class Main {
    public static void pingPongReentrant(){
        PingPong2 pingPong2 = new PingPong2();
        Thread thread1 = new Thread(() -> {
            while(true)
                pingPong2.ping();
        });

        Thread thread2 = new Thread(() -> {
            while(true)
                pingPong2.pong();
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        pingPongReentrant();
    }
}

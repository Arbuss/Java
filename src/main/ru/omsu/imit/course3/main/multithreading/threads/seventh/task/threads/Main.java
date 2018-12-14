package ru.omsu.imit.course3.main.multithreading.threads.seventh.task.threads;

public class Main {
    public static void pingPong(){
        PingPong pingPong = new PingPong();
        Ping ping = new Ping(pingPong);
        Pong pong= new Pong(pingPong);
        new Thread(ping).start();
        new Thread(pong).start();
    }

    public static void main(String[] args) {
        pingPong();
    }
}

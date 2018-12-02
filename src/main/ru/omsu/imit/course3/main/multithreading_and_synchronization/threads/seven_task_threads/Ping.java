package ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.seven_task_threads;

public class Ping extends Thread{
    PingPong pingPong;

    public Ping(PingPong pingPong){
        this.pingPong=pingPong;
    }

    public void run(){
        while(true) {
            pingPong.ping();
        }
    }
}

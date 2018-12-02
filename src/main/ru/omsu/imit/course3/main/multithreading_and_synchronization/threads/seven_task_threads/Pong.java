package ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.seven_task_threads;

public class Pong extends Thread{
    PingPong pingPong;

    public Pong(PingPong pingPong){
        this.pingPong=pingPong;
    }

    public void run(){
        while(true) {
            pingPong.pong();
        }
    }
}

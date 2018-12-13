package ru.omsu.imit.course3.main.multithreading_and_synchronization.fifteen_task;

import java.util.Arrays;

public class Executors extends Thread{
    private DataQueue queue;

    public Executors(DataQueue queue){
        this.queue = queue;
    }

    public Data read(){
        return queue.poll();
    }

    public void run(){
        for(int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(read().get()));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

            }
        }
    }
}

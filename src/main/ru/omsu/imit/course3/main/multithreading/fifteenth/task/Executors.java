package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

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
        while(true) {
            try {
                System.out.println(Arrays.toString(read().get()));
            } catch (InterruptedException e) {
            }

        }
    }
}

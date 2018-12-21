package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.Arrays;

public class Executors extends Thread{
    private DataQueue queue;
    int repeatCount;

    public Executors(DataQueue queue, int repeatCount){
        this.queue = queue;
        this.repeatCount = repeatCount;
    }

    public Data read() throws InterruptedException {
        return queue.take();
    }

    public void run(){
        Data data;
        try {
            while ((data = read()).getClass() != Poison.class) {
                Arrays.stream(data.get()).forEach(System.out::println);
            }
        } catch (InterruptedException e) {

        }
    }
}

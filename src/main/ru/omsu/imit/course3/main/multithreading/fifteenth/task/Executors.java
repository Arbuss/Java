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
        try (BufferedOutputStream bos = new BufferedOutputStream(System.out)) {
            for(int i = 0; i < repeatCount; i++) {
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

package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataQueue {
    private ArrayBlockingQueue<Data> queue;

    public DataQueue(int capacity){
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public void add(Data elem){
        queue.add(elem);
    }

    public void put(Data elem) throws InterruptedException {
        queue.put(elem);
    }

    public Data peek(){
        return queue.peek();
    }

    public Data poll(){
        return queue.poll();
    }

    public Data poll(long timeout) throws InterruptedException {
        return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }

    public Data take() throws InterruptedException {
        return queue.take();
    }

    public void addPoison() throws InterruptedException {
        queue.put(new Poison());
    }

    public int remainingCapacity(){
        return queue.remainingCapacity();
    }
}

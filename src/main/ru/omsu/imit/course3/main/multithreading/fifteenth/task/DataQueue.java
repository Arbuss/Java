package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataQueue {
    private Queue<Data> queue;
    private ReadWriteLock locker;

    public DataQueue(){
        queue = new PriorityQueue<>();
        locker = new ReentrantReadWriteLock();
    }

    public void add(Data elem){
        Lock writeLock = locker.writeLock();
        writeLock.lock();
        queue.add(elem);
        writeLock.unlock();
    }

    public Data peek(){
        return queue.peek();
    }

    public Data poll(){
        Lock readLock = locker.readLock();
        readLock.lock();
        Data data = queue.poll();
        readLock.unlock();
        return data;
    }
}

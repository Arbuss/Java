package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultistageTaskQueue {
    private Queue<MultistageTask> queue;
    private ReadWriteLock locker;

    public MultistageTaskQueue(){
        queue = new PriorityQueue<>();
        locker = new ReentrantReadWriteLock();
    }

    public void add(MultistageTask task){
        Lock writeLock = locker.writeLock();
        writeLock.lock();
        queue.add(task);
        writeLock.unlock();
    }

    public MultistageTask poll(){
        Lock readLock = locker.readLock();
        readLock.lock();
        MultistageTask task = queue.poll();
        readLock.unlock();
        return task;
    }
}

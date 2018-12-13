package ru.omsu.imit.course3.main.multithreading_and_synchronization.sixteen_task;

import ru.omsu.imit.course3.main.multithreading_and_synchronization.fifteen_task.Data;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TaskQueue {
    private Queue<Executable> queue;
    private ReadWriteLock locker;

    public TaskQueue(){
        queue = new PriorityQueue<>();
        locker = new ReentrantReadWriteLock();
    }

    public void add(Executable task){
        Lock writeLock = locker.writeLock();
        writeLock.lock();
        queue.add(task);
        writeLock.unlock();
    }

    public Executable peek(){
        return queue.peek();
    }

    public Executable poll(){
        Lock readLock = locker.readLock();
        readLock.lock();
        Executable task = queue.poll();
        readLock.unlock();
        return task;
    }
}

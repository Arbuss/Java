package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultistageTaskQueue {
    private ArrayBlockingQueue<MultistageTask> queue;

    public MultistageTaskQueue(int capacity){
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public void put(MultistageTask task) throws InterruptedException {
        queue.put(task);
    }

    public MultistageTask take() throws InterruptedException {
        return queue.take();
    }
}

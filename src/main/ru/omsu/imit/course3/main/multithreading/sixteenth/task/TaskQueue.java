package ru.omsu.imit.course3.main.multithreading.sixteenth.task;

import java.util.concurrent.ArrayBlockingQueue;

public class TaskQueue {
    private ArrayBlockingQueue<Executable> queue;

    public TaskQueue(int capacity){
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public void put(Executable task) throws InterruptedException {
        queue.put(task);
    }

    public Executable take() throws InterruptedException {
        return queue.take();
    }
}

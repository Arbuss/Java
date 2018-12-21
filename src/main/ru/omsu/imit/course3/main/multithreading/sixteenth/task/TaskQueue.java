package ru.omsu.imit.course3.main.multithreading.sixteenth.task;

import ru.omsu.imit.course3.main.multithreading.fifteenth.task.Poison;

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

    public void addPoison() throws InterruptedException {
        queue.put(new ru.omsu.imit.course3.main.multithreading.sixteenth.task.Poison());
    }
}

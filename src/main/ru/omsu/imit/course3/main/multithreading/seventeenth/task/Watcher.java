package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import java.util.concurrent.ArrayBlockingQueue;

import static ru.omsu.imit.course3.main.multithreading.seventeenth.task.Main.taskCount;

public class Watcher extends Thread{
    private ArrayBlockingQueue<MultistageTask> queue;

    public Watcher(ArrayBlockingQueue<MultistageTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("-------");
            System.out.println("remaining stages " + taskCount.get());
            for (MultistageTask mTask : queue) {
                System.out.println(mTask.toString());
            }
            System.out.println("-------");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }

            if(taskCount.get() <= 0){
                break;
            }
        }
    }
}

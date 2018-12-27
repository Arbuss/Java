package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;
import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Task;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.omsu.imit.course3.main.multithreading.seventeenth.task.Main.taskCount;

public class Developer extends Thread{
    private ArrayBlockingQueue<MultistageTask> queue;

    public Developer(ArrayBlockingQueue<MultistageTask> queue) {
        this.queue = queue;
    }

    private MultistageTask develop(){
        Executable[] tasks = new Task[3];

        for(int i = 0; i < 3; i++){
            taskCount.incrementAndGet();
            tasks[0] = new Task();
        }

        return new MultistageTask(Thread.currentThread().getName() + "task", tasks);
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            try {
                queue.put(develop());
            } catch (InterruptedException e) {

            }
        }
    }
}

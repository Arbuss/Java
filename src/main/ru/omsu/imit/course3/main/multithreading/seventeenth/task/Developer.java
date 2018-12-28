package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;
import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Task;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.omsu.imit.course3.main.multithreading.seventeenth.task.Main.MULTISTAGE_TASK_COUNT;
import static ru.omsu.imit.course3.main.multithreading.seventeenth.task.Main.taskCount;

public class Developer extends Thread{
    private ArrayBlockingQueue<MultistageTask> queue;
    private int stagesCount;

    public Developer(ArrayBlockingQueue<MultistageTask> queue, int stagesCount) {
        this.queue = queue;
        this.stagesCount = stagesCount;
    }

    private MultistageTask develop(){
        Executable[] tasks = new Task[3];

        for(int i = 0; i < stagesCount; i++){
            tasks[i] = new Task();
        }

        return new MultistageTask(Thread.currentThread().getName() + "task", tasks);
    }

    @Override
    public void run() {
        for(int i = 0; i < MULTISTAGE_TASK_COUNT; i++){
            try {
                queue.put(develop());
            } catch (InterruptedException e) {
                System.out.println("interrupted exception on developer" + Thread.currentThread().getId());
            }
        }
    }
}

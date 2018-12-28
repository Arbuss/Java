package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import static ru.omsu.imit.course3.main.multithreading.seventeenth.task.Main.taskCount;

public class Executor extends Thread{
    private ArrayBlockingQueue<MultistageTask> queue;

    public Executor(ArrayBlockingQueue<MultistageTask> queue) {
        this.queue = queue;
    }

    private Executable getTask(){
        try {
            MultistageTask mTask = queue.take();
            Executable task = mTask.getStage();
            if(mTask.hasStage()){
                queue.put(mTask);
            }

            return task;
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override
    public void run() {
        while (true){
            Executable task = getTask();
            if(task != null ) {
                taskCount.decrementAndGet();
                task.execute();
            }
            if(taskCount.get()  <= 0){
                break;
            }
        }
    }
}

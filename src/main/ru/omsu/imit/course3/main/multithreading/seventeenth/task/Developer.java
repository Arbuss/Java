package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Task;

public class Developer extends Thread{
    private MultistageTaskQueue queue;
    private int repeatCount;

    public Developer(MultistageTaskQueue queue, int repeatCount){
        this.queue = queue;
        this.repeatCount = repeatCount;
    }

    private void develop(){
        Task task = new Task();
        Task task1 = new Task();

        MultistageTask mTask = new MultistageTask("task" + Thread.currentThread().getId(),task, task1);
        try {
            queue.put(mTask);
        } catch (InterruptedException e) {

        }
    }

    public void run(){
        for(int i = 0; i < repeatCount; i++){
            develop();
        }
    }
}

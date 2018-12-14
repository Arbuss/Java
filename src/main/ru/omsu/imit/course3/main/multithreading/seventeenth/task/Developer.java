package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Task;

public class Developer extends Thread{
    private MultistageTaskQueue queue;

    public Developer(MultistageTaskQueue queue){
        this.queue = queue;
    }

    private void develop(){
        Task task = new Task();
        Task task1 = new Task();

        MultistageTask mTask = new MultistageTask("task" + Thread.currentThread().getId(),task, task1);
        queue.add(mTask);
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            develop();
        }
    }
}

package ru.omsu.imit.course3.main.multithreading_and_synchronization.sixteen_task;

public class Executor extends Thread{
    private TaskQueue queue;

    public Executor(TaskQueue queue){
        this.queue = queue;
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            queue.poll().execute();
        }
    }
}

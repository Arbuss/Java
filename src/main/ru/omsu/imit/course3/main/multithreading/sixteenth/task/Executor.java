package ru.omsu.imit.course3.main.multithreading.sixteenth.task;

public class Executor extends Thread{
    private TaskQueue queue;
    private int repeatCount;

    public Executor(TaskQueue queue, int repeatCount){
        this.queue = queue;
        this.repeatCount = repeatCount;
    }

    public void run(){
        for(int i = 0; i < repeatCount; i++){
            try {
                queue.take().execute();
            } catch (InterruptedException e) {

            }
        }
    }
}

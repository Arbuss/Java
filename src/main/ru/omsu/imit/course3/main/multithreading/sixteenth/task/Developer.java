package ru.omsu.imit.course3.main.multithreading.sixteenth.task;

public class Developer extends Thread{
    private TaskQueue queue;

    public Developer(TaskQueue queue){
        this.queue = queue;
    }

    public void develop(){
        Task task = new Task();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        queue.add(task);
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            develop();
        }
    }
}

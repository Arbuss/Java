package ru.omsu.imit.course3.main.multithreading.sixteenth.task;

public class Developer extends Thread{
    private TaskQueue queue;

    public Developer(TaskQueue queue){
        this.queue = queue;
    }

    public void develop() throws InterruptedException {
        Task task = new Task();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        queue.put(task);
    }

    public void run(){
        while(true){
            try {
                develop();
            } catch (InterruptedException e) {

            }
        }
    }
}

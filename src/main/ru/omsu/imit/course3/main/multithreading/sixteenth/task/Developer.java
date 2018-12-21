package ru.omsu.imit.course3.main.multithreading.sixteenth.task;

public class Developer extends Thread{
    private TaskQueue queue;
    private int repeatCount;

    public Developer(TaskQueue queue, int repeatCount){
        this.queue = queue;
        this.repeatCount = repeatCount;
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
        for(int i = 0; i < repeatCount; i++){
            try {
                develop();
            } catch (InterruptedException e) {

            }
        }
    }
}

package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

public class Developer extends Thread{
    private DataQueue queue;
    private int repeatCount;

    public Developer(DataQueue queue, int repeatCount){
        this.queue = queue;
        this.repeatCount = repeatCount;
    }

    public void write() throws InterruptedException {
        Data data = new Data();
        queue.put(data);
    }

    public void run(){
        for(int i = 0; i < repeatCount; i++) {
            try {
                write();
            } catch (InterruptedException e) {

            }
        }
        try {
            queue.addPoison();
        } catch (InterruptedException e) {

        }
    }
}

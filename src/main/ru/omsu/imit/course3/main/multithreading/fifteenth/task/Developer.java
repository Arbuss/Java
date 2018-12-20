package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

public class Developer extends Thread{
    private DataQueue queue;

    public Developer(DataQueue queue){
        this.queue = queue;
    }

    public void write() throws InterruptedException {
        Data data = new Data();
        queue.put(data);
    }

    public void run(){
        while(true) {
            try {
                write();
            } catch (InterruptedException e) {

            }
        }

    }
}

package ru.omsu.imit.course3.main.multithreading_and_synchronization.fifteen_task;

public class Developer extends Thread{
    private DataQueue queue;

    public Developer(DataQueue queue){
        this.queue = queue;
    }

    public void write(){
        Data data = new Data();
        queue.add(data);
    }

    public void run(){
        for(int i = 0; i < 10; i++) {
            write();
        }
    }
}

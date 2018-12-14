package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

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
        while(true) {
            if(queue.remainingCapacity() > 0) {
                System.out.println("im write");
                write();
            }
        }
    }
}

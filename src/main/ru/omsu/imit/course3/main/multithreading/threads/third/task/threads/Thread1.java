package ru.omsu.imit.course3.main.multithreading.threads.third.task.threads;

public class Thread1 extends Thread{
    public Thread1(String name){
        super(name);
    }

    public void run(){
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}
package ru.omsu.imit.course3.main.multithreading.threads.second.task.threads;

public class Main {
    public static String createAndWaitNewThread(){
        Thread thread = new Thread();
        try{
            thread.join();
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.printf("%s has been interrupted", thread.getName());
        }
        return "threads finished";
    }

    public static void main(String[] args){
        System.out.println(createAndWaitNewThread());
    }
}

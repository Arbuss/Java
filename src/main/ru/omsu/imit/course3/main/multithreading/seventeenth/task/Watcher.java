package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

public class Watcher extends Thread{
    private Executor[] executors;

    public Watcher(Executor ... executors){
        this.executors = executors;
    }

    public void watch(){
        for(Executor executor: executors){
            if(executor.isAlive()){
                System.out.println(executor.getTaskName() + "; Stages " + executor.getStageNumber() + "/"
                        + executor.getStagesCount());
            }
        }
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            watch();
        }
    }
}

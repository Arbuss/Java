package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;

public class Executor extends Thread{
    private MultistageTaskQueue queue;
    private MultistageTask mTask;

    public Executor(MultistageTaskQueue queue){
        this.queue = queue;
    }

    public String getTaskName(){
        return mTask.getName();
    }

    public int getStagesCount(){
        return mTask.getSize();
    }

    public int getStageNumber(){
        return mTask.getStagesNum();
    }

    public void doThis(){
        mTask = queue.poll();
        if(!mTask.hasStage()){
            return;
        }

        try {
            Executable task = mTask.getStage();
            task.execute();
            if(mTask.hasStage()){
                queue.add(mTask);
            }
        } catch (CompleteTaskException e) {
        }
    }

    public void run(){
        doThis();
    }
}

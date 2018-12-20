package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;

public class Executor extends Thread{
    private MultistageTaskQueue queue;
    private MultistageTask mTask;

    public Executor(MultistageTaskQueue queue){
        this.queue = queue;
    }

    public String getTaskName() throws NullPointerException{
        return mTask.getName();
    }

    public int getStagesCount() throws NullPointerException {
        return mTask.getSize();
    }

    public int getStageNumber() throws NullPointerException {
        return mTask.getStagesNum();
    }

    public void doThis()  {
        try {
            mTask = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!mTask.hasStage()){
            return;
        }

        try {
            Executable task = mTask.getStage();
            task.execute();
            if(mTask.hasStage()){
                queue.put(mTask);
            }
        } catch (CompleteTaskException e) {
        } catch (InterruptedException e) {
        }
    }

    public void run(){
        while(true) {
            doThis();
        }
    }
}

package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;

public class Executor extends Thread{
    private MultistageTaskQueue queue;

    public Executor(MultistageTaskQueue queue){
        this.queue = queue;
    }

    public void doThis(){
        MultistageTask mTask = queue.poll();
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

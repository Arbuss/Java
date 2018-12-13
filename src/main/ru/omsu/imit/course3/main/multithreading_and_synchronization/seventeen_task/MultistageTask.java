package ru.omsu.imit.course3.main.multithreading_and_synchronization.seventeen_task;

import ru.omsu.imit.course3.main.multithreading_and_synchronization.sixteen_task.Executable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MultistageTask implements Executable, Comparable {
    private List<Executable> stages;

    public MultistageTask(Executable ...stages){
        this.stages = new LinkedList<>();
        this.stages.addAll(Arrays.asList(stages));
    }

    public MultistageTask(MultistageTask mTask){
        this((Executable[]) mTask.getStages().toArray());
    }

    private Executable getStage() throws CompleteTaskException {
        if(!stages.isEmpty())
            return stages.get(0);
        else
            throw new CompleteTaskException("All stages complete");
    }

    public List<Executable> getStages(){
        return stages;
    }

    @Override
    public synchronized void execute() {
        try {
            Thread.sleep(500);
            Executable stage = getStage();
            stages.remove(stage);
            System.out.println("Task completed");
        } catch (InterruptedException e) {

        } catch (CompleteTaskException e) {

        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

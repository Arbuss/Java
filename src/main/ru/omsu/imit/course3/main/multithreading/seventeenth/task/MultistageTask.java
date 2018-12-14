package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MultistageTask implements Executable, Comparable {
    private List<Executable> stages;
    private String name;

    public MultistageTask(String name, Executable ...stages){
        this.stages = new LinkedList<>();
        this.stages.addAll(Arrays.asList(stages));
    }

    public MultistageTask(MultistageTask mTask, String name){
        this(name, (Executable[]) mTask.getStages().toArray());
    }

    public Executable getStage() throws CompleteTaskException {
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

    public String getName(){
        return name;
    }

    public boolean hasStage(){
        return stages.size() != 0;
    }

    public int getStagesNum(){
        return stages.size();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

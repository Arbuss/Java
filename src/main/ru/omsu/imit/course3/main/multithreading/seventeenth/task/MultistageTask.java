package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;

import java.util.*;

import static ru.omsu.imit.course3.main.multithreading.seventeenth.task.Main.taskCount;

public class MultistageTask{
    private LinkedList<Executable> stages;
    private String name;
    private int stagesCount;

    public MultistageTask(String name, Executable ...stages) {
        this(name, Arrays.asList(stages));
    }

    public MultistageTask(String name, List<Executable> stages) {
        this.stages = new LinkedList<>(stages);
        this.name = name;
        stagesCount = stages.size();
    }

    public MultistageTask(){
        stages = new LinkedList();
    }

    public String getName() {
        return name;
    }

    public synchronized boolean hasStage(){
        return stages.size() > 0;
    }

    public Executable getStage(){
        try {
            synchronized (stages) {
                Executable stage = stages.pollFirst();
                return stage;
            }

        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public String toString() {
        synchronized (stages) {
            return name + " " + stages.size() + "/" + stagesCount;
        }
    }

    public synchronized void setPoison(){
        stages.add(new Poison());
    }

    public synchronized LinkedList<Executable> getStages(){
        return stages;
    }

    public synchronized void setStages(LinkedList<Executable> list){
        this.stages = list;
    }
}

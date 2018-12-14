package ru.omsu.imit.course3.main.multithreading.threads.sixth.task.threads;

import ru.omsu.imit.course3.main.multithreading.threads.ThreadsConstants;

import java.util.List;
import java.util.Random;

public class AddAndDelThreadSynchList extends Thread{
    private List list;

    public AddAndDelThreadSynchList(List list){
        this.list = list;
    }

    public void add(){
        Random random = new Random();
        for (int i = 0; i < ThreadsConstants.TEST_NUM_FOR_TASK; i++) {
            list.add(random.nextInt());
        }
    }

    public void del(){
        Random random = new Random();
        try {
            for (int i = 0; i < ThreadsConstants.TEST_NUM_FOR_TASK; i++) {
                list.remove(random.nextInt(ThreadsConstants.TEST_NUM_FOR_TASK));
            }

        } catch(IndexOutOfBoundsException e){ }
    }

    public void run(){
        add();
        del();
    }
}

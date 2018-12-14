package ru.omsu.imit.course3.main.multithreading.threads.fifth.task.threads;

import ru.omsu.imit.course3.main.multithreading.threads.ThreadsConstants;

import java.util.List;
import java.util.Random;

public class AddDelThread extends Thread{
    private List list;

    public AddDelThread(List list){
        this.list = list;
    }

    public synchronized void add(){
        Random random = new Random();
        for (int i = 0; i < ThreadsConstants.TEST_NUM_FOR_TASK; i++) {
            list.add(random.nextInt());
        }
    }

    public synchronized void del(){
        Random random = new Random();
        try {
            for (int i = 0; i < ThreadsConstants.TEST_NUM_FOR_TASK; i++) {
                list.remove(random.nextInt(ThreadsConstants.TEST_NUM_FOR_TASK));
            }
        } catch(ArrayIndexOutOfBoundsException e){

        }
    }

    public void run(){
        add();
        del();
    }
}

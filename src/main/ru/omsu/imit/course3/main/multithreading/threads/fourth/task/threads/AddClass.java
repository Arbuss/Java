package ru.omsu.imit.course3.main.multithreading.threads.fourth.task.threads;

import ru.omsu.imit.course3.main.multithreading.threads.ThreadsConstants;

import java.util.List;
import java.util.Random;

public class AddClass extends Thread{
    private List list;

    public AddClass(List list){
        this.list = list;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < ThreadsConstants.TEST_NUM_FOR_TASK; i++) {
            synchronized (list) {
                list.add(random.nextInt());
            }
        }
    }
}

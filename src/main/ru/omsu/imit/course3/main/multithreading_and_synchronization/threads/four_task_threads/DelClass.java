package ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.four_task_threads;

import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.ThreadsConstants;

import java.util.List;
import java.util.Random;

public class DelClass extends Thread {
    private List list;

    public DelClass(List list) {
        this.list = list;
    }

    public void run() {
        Random random = new Random();
        synchronized (list) {
            try {
                for (int i = 0; i < ThreadsConstants.TEST_NUM_FOR_TASK; i++) {
                    list.remove(random.nextInt(ThreadsConstants.TEST_NUM_FOR_TASK));
                }
            } catch(IndexOutOfBoundsException e){

            }
        }
    }
}
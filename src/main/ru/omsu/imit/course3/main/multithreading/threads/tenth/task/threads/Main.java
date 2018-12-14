package ru.omsu.imit.course3.main.multithreading.threads.tenth.task.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static ru.omsu.imit.course3.main.multithreading.threads.ThreadsConstants.TEST_NUM_FOR_TASK;

public class Main {
    public static void addAndDelReentrant(){
        ReentrantLock locker = new ReentrantLock();

        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        Thread thread1 = new Thread(() -> {
            locker.lock();
            for (int i = 0; i < TEST_NUM_FOR_TASK; i++)
                list.add(i);
            locker.unlock();
        });

        Thread thread2 = new Thread(() -> {
            locker.lock();
            try {
                for (int i = 0; i < TEST_NUM_FOR_TASK; i++)
                    list.remove(random.nextInt(TEST_NUM_FOR_TASK));
            } catch(IndexOutOfBoundsException e){ }
            finally {
                locker.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        addAndDelReentrant();
    }
}

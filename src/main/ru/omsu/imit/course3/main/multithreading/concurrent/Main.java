package ru.omsu.imit.course3.main.multithreading.concurrent;

import java.util.NoSuchElementException;
import java.util.Random;

import static ru.omsu.imit.course3.main.multithreading.threads.ThreadsConstants.TEST_NUM_FOR_TASK;

public class Main {
    public static void concurrentHashMapThreads(){
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        Random rnd = new Random();

        Thread adder = new Thread(() -> {
            for(int i = 0; i < TEST_NUM_FOR_TASK / 100; i++)
                map.put(i, Integer.toString(i));
        });

        Thread reader = new Thread(() -> {
            try {
                for (int i = 0; i < TEST_NUM_FOR_TASK / 100; i++)
                    map.get(i);
            } catch(NoSuchElementException el){}
        });

        Thread randomReader = new Thread(() -> {
            for(int i = 0; i < 100; i++)
                map.get(rnd.nextInt(TEST_NUM_FOR_TASK));
        });

        adder.start();
        randomReader.start();
        reader.start();
    }

    public static void main(String[] args) {
        concurrentHashMapThreads();
    }
}

package ru.omsu.imit.course3.main.multithreading_and_synchronization.fifteen_task;

public class Data implements Comparable{
    public int[] get(){
        return new int[]{(int) Thread.currentThread().getId(), Thread.currentThread().getPriority()};
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

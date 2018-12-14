package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

public class Data implements Comparable{
    public int[] get(){
        return new int[]{(int) Thread.currentThread().getId(), Thread.currentThread().getPriority()};
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

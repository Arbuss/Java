package ru.omsu.imit.course3.main.multithreading.sixteenth.task;

public class Task implements Executable, Comparable{

    @Override
    public void execute() {
        try {
            Thread.sleep(500);
            System.out.println("Task completed");
        } catch (InterruptedException e) {

        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

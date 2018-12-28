package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import ru.omsu.imit.course3.main.multithreading.sixteenth.task.Executable;

import static ru.omsu.imit.course3.main.multithreading.seventeenth.task.Main.taskCount;

public class Task implements Executable {
    @Override
    public void execute() {
        System.out.println("task complete");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

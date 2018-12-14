package ru.omsu.imit.course3.main.multithreading.threads.fifth.task.threads;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void addAndDelListElems(){
        List<Integer> list = new ArrayList();

        AddDelThread addDelThread = new AddDelThread(list);
        AddDelThread addDelThread2 = new AddDelThread(list);

        addDelThread.start();
        addDelThread2.start();
    }

    public static void main(String[] args){
        addAndDelListElems();
    }
}

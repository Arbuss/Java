package ru.omsu.imit.course3.main.multithreading.threads.sixth.task.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void addAndDelListElems(){
        List<Integer> list = new ArrayList();
        AddAndDelThreadSynchList thread = new AddAndDelThreadSynchList(Collections.synchronizedList(list));

        thread.run();
    }

    public static void main(String[] args){
        addAndDelListElems();
    }
}

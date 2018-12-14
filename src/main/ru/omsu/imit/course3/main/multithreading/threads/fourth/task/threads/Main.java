package ru.omsu.imit.course3.main.multithreading.threads.fourth.task.threads;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void addAndDelListElems(){
        List<Integer> list = new ArrayList();

        AddClass add = new AddClass(list);
        DelClass del = new DelClass(list);

        add.start();
        del.start();
    }

    public static void main(String[] args){
        addAndDelListElems();
    }
}

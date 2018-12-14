package ru.omsu.imit.course3.main.multithreading.threads.first.task.threads;

public class Main {
    public static String getAllProperties(){
        return Thread.currentThread().toString();
    }

    public static void main(String[] args){
        System.out.println(getAllProperties());
    }
}

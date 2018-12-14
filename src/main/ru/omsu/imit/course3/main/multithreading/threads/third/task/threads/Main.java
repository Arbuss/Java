package ru.omsu.imit.course3.main.multithreading.threads.third.task.threads;

public class Main {
    public static String createAndWaitThreeNewThreads() throws InterruptedException {
        Thread1 thread1 = new Thread1("thread1");
        Thread2 thread2 = new Thread2("thread2");
        Thread3 thread3 = new Thread3("thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        return "All threads finished";
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(createAndWaitThreeNewThreads());
    }
}

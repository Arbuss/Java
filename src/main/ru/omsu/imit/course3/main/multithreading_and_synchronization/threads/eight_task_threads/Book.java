package ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.eight_task_threads;

public class Book {
    private int pages;

    public Book(){
        pages = 0;
    }

    public synchronized void read(){
        while(pages > 0){
           pages--;
            System.out.println("i am reading");
        }

        if(pages == 0) {
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void write(){
        int maxPages = pages + 2;

        while(pages < maxPages){
            pages++;
            System.out.println("i write");
        }

        try {
            notifyAll();
            wait();
        } catch (InterruptedException e) {
        }
    }
}

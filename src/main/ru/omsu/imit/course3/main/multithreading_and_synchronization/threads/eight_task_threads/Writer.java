package ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.eight_task_threads;

public class Writer extends Thread{
    Book book;

    public Writer(Book book){
        this.book = book;
    }

    public void run(){
        while(true)
            book.write();
    }
}

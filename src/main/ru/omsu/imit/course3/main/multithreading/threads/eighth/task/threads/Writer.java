package ru.omsu.imit.course3.main.multithreading.threads.eighth.task.threads;

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

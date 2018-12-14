package ru.omsu.imit.course3.main.multithreading.threads.eighth.task.threads;

public class Reader extends Thread{
    Book book;

    public Reader(Book book){
        this.book = book;
    }

    public void run(){
        while(true)
            book.read();
    }
}

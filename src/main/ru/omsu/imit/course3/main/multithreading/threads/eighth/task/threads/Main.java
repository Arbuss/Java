package ru.omsu.imit.course3.main.multithreading.threads.eighth.task.threads;

public class Main {
    public static void readerWriter(){
        Book book = new Book();
        Writer writer = new Writer(book);
        Reader reader = new Reader(book);

        new Thread(writer).start();
        new Thread(reader).start();
    }

    public static void main(String[] args) {
        readerWriter();
    }
}

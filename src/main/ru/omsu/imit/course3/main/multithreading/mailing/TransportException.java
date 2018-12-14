package ru.omsu.imit.course3.main.multithreading.mailing;

public class TransportException extends Exception{
    private String message;

    public TransportException(String message){
        super(message);
    }
}

package ru.omsu.imit.course3.main.multithreading_and_synchronization.mailing;

public class TransportException extends Exception{
    private String message;

    public TransportException(String message){
        super(message);
    }
}

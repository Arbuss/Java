package ru.omsu.imit.course3.main.collections.exceptions;

public class GroupException extends Exception{
    private String message;

    public GroupException(String message){
        super(message);
    }
}

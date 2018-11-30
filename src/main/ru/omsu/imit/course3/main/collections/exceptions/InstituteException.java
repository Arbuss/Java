package ru.omsu.imit.course3.main.collections.exceptions;

public class InstituteException extends Exception{
    private String message;

    public InstituteException(String message){
        super(message);
    }
}

package ru.omsu.imit.course3.main.collections.exceptions;

public enum GroupErrorCodes {
    NULL_NAME("Group name is empty"),
    NULL_TRAINEES("Trainees is null");

    private final String exceptionText;

    GroupErrorCodes(String exceptionText){
        this.exceptionText = exceptionText;
    }

    public String getErrorText(){
        return exceptionText;
    }
}

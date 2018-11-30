package ru.omsu.imit.course3.main.collections.exceptions;

public enum InstituteErrorCodes {
    NULL_NAME("Institute name is empty"),
    NULL_CITY("City name is empty");

    private final String exceptionText;

    InstituteErrorCodes(String exceptionText){
        this.exceptionText = exceptionText;
    }

    public String getErrorText(){
        return exceptionText;
    }
}

package ru.omsu.imit.course3.main.multithreading.mailing;

public enum TransportErrorCodes {
    SERVER_NULL("Server not found");

    private final String exceptionText;

    TransportErrorCodes(String exceptionText){
        this.exceptionText = exceptionText;
    }

    public String getErrorText(){
        return exceptionText;
    }
}

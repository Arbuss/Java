package ru.omsu.imit.course3.main.multithreading_and_synchronization.mailing;

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

package ru.omsu.imit.course3.main.first_task.trainee;

public enum TraineeErrorCodes {
    EMPTY_FIRST_NAME("First name is empty"),
    EMPTY_SECOND_NAME("Second name is empty"),
    INCORRECT_MARK("Mark more than 5 or less than 1");

    private final String exceptionText;

    TraineeErrorCodes(String exceptionText){
        this.exceptionText = exceptionText;
    }

    String getErrorText(){
        return exceptionText;
    }
}

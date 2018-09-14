package src.ru.omsu.imit.cource3.main.FirstTask;

public enum TraineeErrorCodes {
    NULL_FIRST_NAME("First name is NULL"),
    NULL_SECOND_NAME("Second name is NULL"),
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

package src.ru.omsu.imit.course3.main.firstTask;

public class TraineeException extends Exception {
    private String message;

    public TraineeException(String message){
          super(message);
    }
}

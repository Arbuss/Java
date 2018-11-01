package ru.omsu.imit.course3.main.first_task.trainee;

public class TraineeException extends Exception {
    private String message;

    public TraineeException(String message){
          super(message);
    }
}

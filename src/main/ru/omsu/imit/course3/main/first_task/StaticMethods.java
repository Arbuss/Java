package ru.omsu.imit.course3.main.first_task;

import com.google.gson.Gson;
import ru.omsu.imit.course3.main.first_task.rectangle.Rectangle;
import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.io.*;

public class StaticMethods {
    public static String serialize(Trainee trainee){
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }




}

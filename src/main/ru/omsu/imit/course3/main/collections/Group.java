package ru.omsu.imit.course3.main.collections;

import com.sun.javaws.exceptions.InvalidArgumentException;
import ru.omsu.imit.course3.main.collections.exceptions.GroupErrorCodes;
import ru.omsu.imit.course3.main.collections.exceptions.GroupException;
import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeErrorCodes;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.util.Optional;

public class Group {
    private String name;
    private Trainee[] trainees;

    public Group(String name, Trainee[] trainees) throws GroupException {
        setName(name);
        setTrainees(trainees);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws GroupException {
        if(name == null)
            throw new GroupException(GroupErrorCodes.NULL_NAME.getErrorText());
        this.name = name;
    }

    public Trainee[] getTrainees() {
        return trainees;
    }

    public void setTrainees(Trainee[] trainees) throws GroupException {
        if(trainees == null)
            throw new GroupException(GroupErrorCodes.NULL_TRAINEES.getErrorText());
        this.trainees = trainees;
    }
}

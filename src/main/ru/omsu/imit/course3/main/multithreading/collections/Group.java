package ru.omsu.imit.course3.main.multithreading.collections;

import ru.omsu.imit.course3.main.collections.exceptions.GroupErrorCodes;
import ru.omsu.imit.course3.main.collections.exceptions.GroupException;
import ru.omsu.imit.course3.main.first.task.trainee.Trainee;

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
        synchronized (name) {
            this.name = name;
        }
    }

    public Trainee[] getTrainees() {
        synchronized (trainees) {
            return trainees;
        }
    }

    public void setTrainees(Trainee[] trainees) throws GroupException {
        if(trainees == null)
            throw new GroupException(GroupErrorCodes.NULL_TRAINEES.getErrorText());
        synchronized (this.trainees) {
        this.trainees = trainees;
        }
    }
}

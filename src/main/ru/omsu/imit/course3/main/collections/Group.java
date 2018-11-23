package ru.omsu.imit.course3.main.collections;

import ru.omsu.imit.course3.main.first_task.trainee.Trainee;

import java.util.Optional;

public class Group {
    private Optional<String> name;
    private Optional<Trainee[]> trainees;

    public Group(String name, Trainee[] trainees) {
        setName(name);
        setTrainees(trainees);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = Optional.ofNullable(name);
    }

    public Trainee[] getTrainees() {
        return trainees.get();
    }

    public void setTrainees(Trainee[] trainees) {
        this.trainees = Optional.ofNullable(trainees);
    }
}

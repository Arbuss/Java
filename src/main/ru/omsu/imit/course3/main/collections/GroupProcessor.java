package ru.omsu.imit.course3.main.collections;

import ru.omsu.imit.course3.main.first_task.trainee.Trainee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GroupProcessor {
    public static Group sortByMarks(Group group){
        return new Group(group.getName(), Arrays.stream(group.getTrainees()).
                sorted(Comparator.comparingInt(Trainee::getMark))
                .toArray(Trainee[]::new));
    }

    public static Group sortByNames(Group group){
        return new Group(group.getName(), Arrays.stream(group.getTrainees()).
                sorted()
                .toArray(Trainee[]::new));
    }

    public static Trainee findTrainee(Group group, String name){
        return Arrays.stream(group.getTrainees()).filter(x -> x.getFirstName().equals(name)).findFirst().get();
    }
}

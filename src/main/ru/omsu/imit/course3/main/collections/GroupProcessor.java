package ru.omsu.imit.course3.main.collections;

import ru.omsu.imit.course3.main.collections.exceptions.GroupException;
import ru.omsu.imit.course3.main.first.task.trainee.Trainee;

import java.util.*;

public class GroupProcessor {
    public static Group sortByMarks(Group group) throws GroupException {
        Arrays.sort(group.getTrainees(), Comparator.comparingInt(Trainee::getMark));
        return new Group(group.getName(), group.getTrainees());
    }

    public static Group sortByNames(Group group) throws GroupException {
        Arrays.sort(group.getTrainees(), Trainee::compareTo);
        return new Group(group.getName(), group.getTrainees());
    }

    public static Trainee findTrainee(Group group, String name){
        for(Trainee trainee: group.getTrainees())
            if(trainee.getFirstName().equals(name))
                return trainee;

        return null;
    }
}

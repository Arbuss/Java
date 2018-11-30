package ru.omsu.imit.course3.main.collections;

import ru.omsu.imit.course3.main.collections.exceptions.GroupException;
import ru.omsu.imit.course3.main.first_task.trainee.Trainee;

import java.util.*;

public class GroupProcessor {
    public static Group sortByMarks(Group group) throws GroupException {
        Set<Trainee> sortedSet = new TreeSet(Comparator.comparingInt(Trainee::getMark));
        sortedSet.addAll(Arrays.asList(group.getTrainees()));
        Trainee[] trainees = new Trainee[sortedSet.size()];
        Iterator it = sortedSet.iterator();
        int traineesIndex = 0;
        while(it.hasNext()){
            trainees[traineesIndex] = (Trainee) it.next();
            traineesIndex++;
        }
        return new Group(group.getName(), trainees);
    }

    public static Group sortByNames(Group group) throws GroupException {
        Set<Trainee> sortedSet = new TreeSet();
        sortedSet.addAll(Arrays.asList(group.getTrainees()));
        Trainee[] trainees = new Trainee[sortedSet.size()];
        Iterator it = sortedSet.iterator();
        int traineesIndex = 0;
        while(it.hasNext()){
            trainees[traineesIndex] = (Trainee) it.next();
            traineesIndex++;
        }
        return new Group(group.getName(), trainees);
    }

    public static Trainee findTrainee(Group group, String name){
        for(Trainee trainee: group.getTrainees())
            if(trainee.getFirstName().equals(name))
                return trainee;

        return null;
    }
}

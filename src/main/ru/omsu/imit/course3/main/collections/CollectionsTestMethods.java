package ru.omsu.imit.course3.main.collections;

import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class CollectionsTestMethods {
    public static List<Trainee> arrayListTestMethods(List<Trainee> traineeList){
        CopyOnWriteArrayList<Trainee> syncList = new CopyOnWriteArrayList<>(traineeList);
        Collections.reverse(syncList);
        Collections.rotate(syncList, 2);
        return syncList;
    }

    public static Trainee findTraineeWithMaxMark(List<Trainee> traineeList) throws TraineeException {
        Trainee maxTrainee = traineeList.get(0);
        int maxMark = maxTrainee.getMark();

        for(Trainee trainee: traineeList){
            int tempMark = trainee.getMark();
            if(maxMark < tempMark) {
                maxTrainee = trainee;
                maxMark = tempMark;
            }
        }
        return maxTrainee;
    }

    public static List<Trainee> sortedByMarks(List<Trainee> traineeList){
        traineeList.sort(Comparator.comparingInt(Trainee::getMark));
        return traineeList;
    }

    public static List<Trainee> sortedByNames(List<Trainee> traineeList) {
        traineeList.sort(Trainee::compareTo);
        return traineeList;
    }

    public static Trainee findTraineeByName(List<Trainee> traineeList, String name) {
        for(Trainee trainee: traineeList){
            if(trainee.getFirstName().equals(name))
                return trainee;
        }
        return null;
    }

    public static Set<Set<Integer>> findSetOfSameStrings(int[][] matrix){
        Set<Set<Integer>> resultSet = new HashSet<>();
        Set<Integer> tempSetFirst = new HashSet<>();
        Set<Integer> tempSetSecond = new HashSet<>();
        for(int i = 0; i < matrix.length - 1; i++){
            for(int j = 0; j < matrix[0].length; j++)
                tempSetFirst.add(matrix[i][j]);

            for(int j = 0; j < matrix[0].length; j++)
                tempSetSecond.add(matrix[i+1][j]);

            if(!tempSetFirst.containsAll(tempSetSecond)) {
                resultSet.add(new HashSet<Integer>(tempSetFirst));
                resultSet.add(new HashSet<Integer>(tempSetSecond));
            }

            tempSetFirst.clear();
            tempSetSecond.clear();
        }
        return resultSet;
    }
}

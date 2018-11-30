package ru.omsu.imit.course3.main.collections;

import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsTestMethods {
    public static List<Trainee> arrayListTestMethods(List<Trainee> traineeList){
        Collections.reverse(traineeList);
        Collections.rotate(traineeList, 2);
        return traineeList;
    }

    public static Trainee findTraineeWithMaxMark(List<Trainee> traineeList) throws TraineeException {
        int maxMark = traineeList.get(0).getMark();
        int traineeIndex = 0;

        for(Trainee trainee: traineeList){
            int tempMark = trainee.getMark();
            if(maxMark < tempMark) {
                traineeIndex = traineeList.indexOf(trainee);
                maxMark = tempMark;
            }
        }
        return traineeList.get(traineeIndex);
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

package ru.omsu.imit.course3.main.collections;

import ru.omsu.imit.course3.main.first_task.trainee.Trainee;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsTestMethods {
    public static List<Trainee> arrayListTestMethods(List<Trainee> traineeList){
        Collections.reverse(traineeList);
        Collections.rotate(traineeList, 2);
        return traineeList;
    }

    public static Trainee findTraineeWithMaxMark(List<Trainee> traineeList){
        return traineeList.stream().max(Comparator.comparingInt(Trainee::getMark)).get();
    }

    public static List<Trainee> sortedByMarks(List<Trainee> traineeList){
        return traineeList.stream().sorted(Comparator.comparingInt(Trainee::getMark)).collect(Collectors.toList());
    }

    public static List<Trainee> sortedByNames(List<Trainee> traineeList) {
        return traineeList.stream().sorted(Trainee::compareTo).collect(Collectors.toList());
    }

    public static Trainee findTraineeByName(List<Trainee> traineeList, String name) {
        return traineeList.stream().filter(x -> x.getFirstName().equals(name)).findFirst().get();
    }

    public static Set<Set<Integer>> findSetOfSameStrings(int[][] matrix){
        Set<Set<Integer>> resultSet = new HashSet<>();
        Set<Integer> tempSetFirst = new HashSet<>();
        Set<Integer> tempSetSecond = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
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

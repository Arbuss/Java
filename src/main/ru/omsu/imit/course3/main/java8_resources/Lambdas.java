package ru.omsu.imit.course3.main.java8_resources;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambdas {
    public static Function<String, List<String>> split = s -> Arrays.asList(s.split(" "));
    public static Function<List<?>, Integer> count = List::size;
    public static MyFunction<String, Integer> splitAndCount = s -> count.compose(split).apply(s);
    public static MyFunction<String, Integer> splitAndCount2 = s -> split.andThen(count).apply(s);
    public static MyFunction<String, Person> createPerson = Person::new;
    public static ToIntBiFunction<Integer, Integer> max = Math::max;
    public static Supplier<Date> getCurrentDate = Date::new;
    public static Predicate<Integer> isEven = i -> i%2 == 0;
    public static BiPredicate<Integer, Integer> areEqual = Integer::equals;

    public static IntStream transform(IntStream stream, IntUnaryOperator op){
        return stream.parallel().map(op);
    }

    public static Function<List<Person>, List<String>> getListOfSortedUniqueNamesPersonsOlderThirtyYears = list ->
            Arrays.stream(list.stream().
                    filter(p -> p.getAge() > 30).
                    sorted(Comparator.comparingInt(p -> p.getName().length())).
                    map(Person::getName).
                    toArray(String[]::new)).distinct().
                    collect(Collectors.toList());

    public static Function<List<Person>, List<String>> getListOfSortedUniqueNamesPersonsOlderThirtyYears2 = list ->
            list.stream().filter(p -> p.getAge() > 30).
                    collect(Collectors.groupingBy(Person::getName)).
                    keySet().stream().collect(Collectors.toList());


    public static int sum(List<Integer> list){
        return list.stream().reduce((x1, x2) -> x1 + x2).orElse(0);
    }

    public static int product(List<Integer> list) {
        return list.stream().reduce((x1, x2) -> x1 * x2).orElse(0);
    }
}

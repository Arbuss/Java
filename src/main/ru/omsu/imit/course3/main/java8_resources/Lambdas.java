package ru.omsu.imit.course3.main.java8_resources;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Lambdas {
    public static Function<String, List<String>> split = s -> Arrays.asList(s.split(" "));
    public static Function<List<?>, Integer> count = List::size;
    public static Function<String, Integer> splitAndCount = s -> count.compose(split).apply(s);
    public static Function<String, Integer> splitAndCount2 = s -> split.andThen(count).apply(s);
    public static Function<String, Person> createPerson = Person::new;
    public static ToIntBiFunction<Integer, Integer> max = Math::max;
    public static Supplier<Date> getCurrentDate = Date::new;
    public static java.util.function.Predicate<Integer> isEven = i -> i%2 == 0;
    }

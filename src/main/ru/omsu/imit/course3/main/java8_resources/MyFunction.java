package ru.omsu.imit.course3.main.java8_resources;

import java.util.Objects;

@FunctionalInterface
public interface MyFunction<T, K> {
    K apply(T arg);
    //K apply(T arg1, T arg2);
}

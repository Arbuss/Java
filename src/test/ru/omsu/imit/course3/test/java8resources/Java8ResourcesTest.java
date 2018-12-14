package ru.omsu.imit.course3.test.java8resources;

import org.junit.Test;
import ru.omsu.imit.course3.main.java8resources.Lambdas;
import ru.omsu.imit.course3.main.java8resources.Person;

import java.util.*;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class Java8ResourcesTest {
    @Test
    public void splitAndCountTest(){
        String str = "Eat more of these soft French buns";
        List<String> resultList = new ArrayList();
        Collections.addAll(resultList,
                "Eat", "more", "of", "these", "soft", "French", "buns");

        List<String> splitStringList = Lambdas.split.apply(str);

        assertEquals(resultList, splitStringList);
        assertEquals(7, (int)Lambdas.count.apply(splitStringList));
        assertEquals(7, (int)Lambdas.splitAndCount.apply(str));
        assertEquals(7, (int)Lambdas.splitAndCount2.apply(str));
    }

    @Test
    public void createPersonTest(){
        assertEquals("name", Lambdas.createPerson.apply("name").getName());
    }

    @Test
    public void maxTest(){
        assertEquals(3, Lambdas.max.applyAsInt(2, 3));
    }

    @Test
    public void dateTest(){
        assertNotNull(Lambdas.getCurrentDate.get());
    }

    @Test
    public void isEvenTest(){
        assertTrue(Lambdas.isEven.test(2));
        assertFalse(Lambdas.isEven.test(1));
        assertFalse(Lambdas.isEven.test(3));
    }

    @Test
    public void transformTest(){
        IntStream intStream = Lambdas.transform(IntStream.of(1, 2, 3, 4, 5, 6), x -> x + 1);
        IntStream intStreamAfterOp = IntStream.of(2, 3, 4, 5, 6, 7);

        assertArrayEquals(intStreamAfterOp.toArray(), intStream.toArray());
    }

    @Test
    public void getListOfSortedUniqueNamesPersonsOlderThirtyYearsTest(){
        List<Person> listOfPerson = new ArrayList<>();
        Collections.addAll(listOfPerson,
                new Person("p1", 31),
                new Person("p2", 29),
                new Person("p1", 32),
                new Person("pp1", 234),
                new Person("ppp1", 54),
                new Person("pp1p", 2)
                );

        List<String> sortedListOfPerson = new ArrayList<>();
        Collections.addAll(sortedListOfPerson,
                "p1", "pp1", "ppp1"
        );

        assertEquals(sortedListOfPerson, Lambdas.getListOfSortedUniqueNamesPersonsOlderThirtyYears.apply(listOfPerson));
    }

    @Test
    public void sumTest(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,
                1, 2, 3, 4, 5, 6);

        assertEquals(21, Lambdas.sum(list));
    }

    @Test
    public void productTest(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,
                1, 2, 3, 4, 5, 6);

        assertEquals(720, Lambdas.product(list));
    }

    @Test
    public void getListOfSortedUniqueNamesPersonsOlderThirtyYearsTest2(){
        List<Person> listOfPerson = new ArrayList<>();
        Collections.addAll(listOfPerson,
                new Person("p1", 31),
                new Person("p1", 32),
                new Person("pp1", 234),
                new Person("ppp1", 54),
                new Person("ppp1", 56),
                new Person("ppp1", 32)
        );

        List<String> sortedListOfPerson = new ArrayList<>();
        Collections.addAll(sortedListOfPerson,
                "pp1", "p1", "ppp1"
        );

        assertEquals(sortedListOfPerson, Lambdas.getListOfSortedUniqueNamesPersonsOlderThirtyYears2.apply(listOfPerson));
    }
}

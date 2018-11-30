package ru.omsu.imit.course3.test.java8_resources;

import org.junit.Test;
import ru.omsu.imit.course3.main.java8_resources.Lambdas;
import ru.omsu.imit.course3.main.java8_resources.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

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
        assertTrue(!(new Date().after(Lambdas.getCurrentDate.get())));
        assertTrue(!(new Date().before(Lambdas.getCurrentDate.get())));
    }

    @Test
    public void isEvenTest(){
        
    }
}

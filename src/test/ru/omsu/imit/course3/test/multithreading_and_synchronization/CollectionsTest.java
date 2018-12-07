package ru.omsu.imit.course3.test.multithreading_and_synchronization;

import org.junit.Test;
import ru.omsu.imit.course3.main.collections.CollectionsTestMethods;
import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollectionsTest {
    @Test
    public void arrayListTestMethodsTest() throws TraineeException {
        final List<Trainee> list = new LinkedList();
        Collections.addAll( list,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
        );

        final List<Trainee> list2 = new LinkedList();
        Collections.addAll( list2,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
        );

        List<Trainee> finalList = new LinkedList();
        Collections.addAll( finalList,
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn3", "sn3", 4)
        );

        Thread thread1 = new Thread(()->{
            CollectionsTestMethods.arrayListTestMethods(list);
        });

        Thread thread2 = new Thread(()->{
            CollectionsTestMethods.arrayListTestMethods(list2);
        });

        thread1.start();
        thread2.start();

        assertEquals(finalList, list);
        assertEquals(finalList, list2);
    }
}

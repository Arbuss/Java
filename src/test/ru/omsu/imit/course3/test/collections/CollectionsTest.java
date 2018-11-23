package ru.omsu.imit.course3.test.collections;

import org.junit.Test;
import ru.omsu.imit.course3.main.collections.Group;
import ru.omsu.imit.course3.main.collections.GroupProcessor;
import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CollectionsTest {
    @Test
    public void constructorTest() throws TraineeException {
        Trainee[] trainees = {new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 4)};
        Group group = new Group("mpb-603", trainees);
        assertArrayEquals(trainees, group.getTrainees());
    }

    @Test(expected = NoSuchElementException.class)
    public void groupConstructorWithExceptionTest(){
        Group group1 = new Group("mpb-603", null);
        assertEquals(null, group1.getTrainees());
    }

    @Test(expected = TraineeException.class)
    public void traineeConstructorWithException() throws TraineeException {
        Trainee trainee = new Trainee("", null, 0);
    }

    @Test
    public void sortByMarksTest() throws TraineeException {
        Trainee[] trainees = {new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4),
        };

        Trainee[] sortedTrainees = {
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn3", "sn3", 4),
                new Trainee("fn2", "sn2", 5)
        };

        Group group = new Group("mpb603", trainees);
        Group sortedGroup = GroupProcessor.sortByMarks(group);

        assertArrayEquals(new Group("mpb603", sortedTrainees).getTrainees(), sortedGroup.getTrainees());
    }

    @Test
    public void sortByNamesTest() throws TraineeException {
        Trainee[] trainees = {new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4),
        };

        Trainee[] sortedTrainees = {
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4),

        };

        Group group = new Group("mpb603", trainees);
        Group sortedGroup = GroupProcessor.sortByNames(group);

        assertArrayEquals(new Group("mpb603", sortedTrainees).getTrainees(), sortedGroup.getTrainees());
    }

    @Test
    public void findTraineeTest() throws TraineeException {
        Trainee[] trainees = {new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4),
        };
        Group group = new Group("mpb603", trainees);


        assertEquals(trainees[1], GroupProcessor.findTrainee(group, "fn2"));
    }
}

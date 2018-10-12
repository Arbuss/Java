package src.ru.omsu.imit.course3.test.firstTask;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import src.ru.omsu.imit.course3.main.firstTask.*;

import java.io.*;

public class WriteReadTest {
    @Test
    public void rectangleWriteTest(){
        Rectangle rectangle = new Rectangle(2, 4, 6, 8);

        Rectangle rectangle1 = StaticMethods.rectangleWriteAndRead(rectangle);

        assertEquals(2.0, rectangle1.getLeftTop().x, 0.0);
        assertEquals(4.0, rectangle1.getLeftTop().y, 0.0);
        assertEquals(6.0, rectangle1.getRightBottom().x, 0.0);
        assertEquals(8.0, rectangle1.getRightBottom().y, 0.0);
    }

    @Test
    public void rectangleWriteTest1() {
        Rectangle[] rectanglesArray = {new Rectangle(1.1, 1.2, 1.3, 1.4),
                new Rectangle(2.1, 2.2, 2.3, 2.4),
                new Rectangle(3.1, 3.2, 3.3, 3.4),
                new Rectangle(4.1, 4.2, 4.3, 4.4),
                new Rectangle(5.1, 5.2, 5.3, 5.4),
        };

        Rectangle[] rectanglesArray1 = StaticMethods.rectangleWriteAndRead2(rectanglesArray);
        assertEquals(rectanglesArray, rectanglesArray1);

    }

    @Test
    public void traineeWriteTest() throws TraineeException {
        Trainee trainee = new Trainee("Андрей", "Чмеренко", 5);
        StaticMethods.traineeWrite(trainee);
        Trainee trainee1 = StaticMethods.traineeRead();
        assertEquals(trainee, trainee1);
    }

    @Test
    public void traineeWriteTest2() throws TraineeException {
        Trainee trainee = new Trainee("Андрей", "Чмеренко", 5);
        StaticMethods.traineeWrite2(trainee);
        Trainee trainee1 = StaticMethods.traineeRead2();
        assertEquals(trainee, trainee1);
    }

    @Test
    public void serializeTest() throws TraineeException {
        Trainee trainee = new Trainee("Андрей", "Чмеренко", 5);

        StaticMethods.serializeWrite(StaticMethods.serialize(trainee));

        Trainee trainee1 = StaticMethods.serializeRead();
        assertEquals(trainee, trainee1);
    }
}

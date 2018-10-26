package ru.omsu.imit.course3.test.first_task;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ru.omsu.imit.course3.main.first_task.Rectangle;
import ru.omsu.imit.course3.main.first_task.StaticMethods;
import ru.omsu.imit.course3.main.first_task.Trainee;
import ru.omsu.imit.course3.main.first_task.TraineeException;
import ru.omsu.imit.course3.main.first_task.*;

import java.io.IOException;

public class WriteReadTest {
    @Test
    public void rectangleWriteTest() throws IOException {
        Rectangle rectangle = new Rectangle(2, 4, 6, 8);
        StaticMethods.rectangleWrite("files//rectangles.bin", rectangle);
        Rectangle rectangle1 = StaticMethods.rectangleRead(rectangle, "files//rectangles.bin");

        assertEquals(2.0, rectangle1.getLeftTop().x, 0.0);
        assertEquals(4.0, rectangle1.getLeftTop().y, 0.0);
        assertEquals(6.0, rectangle1.getRightBottom().x, 0.0);
        assertEquals(8.0, rectangle1.getRightBottom().y, 0.0);
    }

    @Test
    public void rectangleWriteTest1() throws IOException {
        Rectangle[] rectanglesArray = {new Rectangle(1.1, 1.2, 1.3, 1.4),
                new Rectangle(2.1, 2.2, 2.3, 2.4),
                new Rectangle(3.1, 3.2, 3.3, 3.4),
                new Rectangle(4.1, 4.2, 4.3, 4.4),
                new Rectangle(5.1, 5.2, 5.3, 5.4),
        };

        Rectangle[] rectanglesArray2 = {new Rectangle(5.4, 5.3, 5.2, 5.1),
                new Rectangle(4.4, 4.3, 4.2, 4.1),
                new Rectangle(3.4, 3.3, 3.2, 3.1),
                new Rectangle(2.4, 2.3, 2.2, 2.1),
                new Rectangle(1.4, 1.3, 1.2, 1.1),
        };
        StaticMethods.rectangleWrite("files//rectangles.bin", rectanglesArray);
        Rectangle[] rectanglesArray1 = StaticMethods.rectangleReadToArray("files//rectangles.bin");
        assertArrayEquals(rectanglesArray2, rectanglesArray1);

        StaticMethods.rectanglesToPrintStream(rectanglesArray1);
    }

    @Test
    public void traineeWriteTest() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Андрей", "Чмеренко", 5);
        StaticMethods.traineeWriteWithLineSeparation(trainee, "files//trainee.txt");
        Trainee trainee1 = StaticMethods.traineeRead("files//trainee.txt");
        assertEquals(trainee, trainee1);
    }

    @Test
    public void traineeWriteTest2() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Андрей", "Чмеренко", 5);
        StaticMethods.traineeWrite(trainee, "files//trainee.txt");
        Trainee trainee1 = StaticMethods.traineeRead2("files//trainee.txt");
        assertEquals(trainee, trainee1);
    }

    @Test
    public void serializeTest() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Андрей", "Чмеренко", 5);

        StaticMethods.serializeWrite(StaticMethods.serialize(trainee), "files//serialize.bin");

        Trainee trainee1 = StaticMethods.serializeRead("files//serialize.bin");
        assertEquals(trainee, trainee1);
    }

    @Test
    public void serializeByteStreamTest() throws TraineeException, IOException, ClassNotFoundException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);

        StaticMethods.ByteArrayOutputStreamSerialization(trainee, "files//serializeBaos.bin");
        //Trainee trainee1 = (Trainee) StaticMethods.ByteArrayInputStreamDeserialization();
        StaticMethods.ByteArrayInputStreamDeserialization("files//serializeBaos.bin");
        //assertEquals(trainee, trainee1);
    }
}

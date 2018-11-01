package ru.omsu.imit.course3.test.first_task;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ru.omsu.imit.course3.main.first_task.rectangle.Rectangle;
import ru.omsu.imit.course3.main.first_task.StaticMethods;
import ru.omsu.imit.course3.main.first_task.rectangle.RectangleInput;
import ru.omsu.imit.course3.main.first_task.rectangle.RectangleOutput;
import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeInput;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeOutput;

import java.io.IOException;

public class WriteReadTest {
    @Test
    public void rectangleWriteTest() throws IOException {
        Rectangle rectangle = new Rectangle(2, 4, 6, 8);
        RectangleOutput.rectangleWrite("files//rectangles.bin", rectangle);
        Rectangle rectangle1 = RectangleInput.rectangleRead(rectangle, "files//rectangles.bin");

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
        RectangleOutput.rectangleWrite("files//rectangles.bin", rectanglesArray);
        Rectangle[] rectanglesArray1 = RectangleInput.rectangleReadToArray("files//rectangles.bin");
        assertArrayEquals(rectanglesArray2, rectanglesArray1);

        RectangleOutput.rectanglesToPrintStream(rectanglesArray1);
    }

    @Test
    public void traineeWriteTest() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);
        TraineeOutput.traineeWriteWithLineSeparation(trainee, "files//trainee.txt");
        Trainee trainee1 = TraineeInput.traineeRead("files//trainee.txt");
        assertEquals(trainee, trainee1);
    }

    @Test
    public void traineeWriteTest2() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);
        TraineeOutput.traineeWrite(trainee, "files//trainee.txt");
        Trainee trainee1 = TraineeInput.traineeRead2("files//trainee.txt");
        assertEquals(trainee, trainee1);
    }

    @Test
    public void serializeTest() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);

        TraineeOutput.serializeWrite(trainee, "files//serialize.bin");

        Trainee trainee1 = TraineeInput.serializeRead("files//serialize.bin");
        assertEquals(trainee, trainee1);
    }

    @Test
    public void serializeByteStreamTest() throws TraineeException, IOException, ClassNotFoundException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);

        TraineeOutput.ByteArrayOutputStreamSerialize(trainee, "files//serializeBaos.bin");
        Trainee trainee1 = TraineeInput.ByteArrayInputStreamDeserialize("files//serializeBaos.bin");
        assertEquals(trainee, trainee1);
    }

    @Test
    public void serializeByGson() throws TraineeException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);
        Trainee trainee1 = TraineeInput.DeserializeByGson(TraineeOutput.serializeByGson(trainee));

        assertEquals(trainee, trainee1);
    }

    @Test
    public void serializeByGsonToFile() throws TraineeException{
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);
    }
}

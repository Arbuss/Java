package ru.omsu.imit.course3.test.nio;

import org.junit.Test;
import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;
import ru.omsu.imit.course3.main.nio.NioReader;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class NioTest {
    @Test
    public void byteBufferFromFileChannelTest() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);
        Trainee trainee1 = NioReader.byteBufferReader("files//trainee.txt");

        assertEquals(trainee, trainee1);
    }

    @Test
    public void mappedByteBufferTest() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);
        Trainee trainee1 = NioReader.mappedByteBufferReader("files//trainee.txt");

        assertEquals(trainee, trainee1);
    }
}

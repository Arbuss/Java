package ru.omsu.imit.course3.test.nio;

import ru.omsu.imit.course3.main.first.task.trainee.Trainee;
import ru.omsu.imit.course3.main.first.task.trainee.TraineeException;
import ru.omsu.imit.course3.main.nio.*;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
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

    @Test
    public void mappedByteBufferWriteTest() throws TraineeException, IOException {
        int[] intsArray = new int[NioConstants.TEST_FILE_SIZE];
        for(int i = 0; i < NioConstants.TEST_FILE_SIZE; i++){
            intsArray[i] = i;
        }

        NioWriter.mappedByteBufferWrite("files//Nio.txt", intsArray);
        int[] intsArray1 = NioReader.dataInputStreamReader("files//Nio.txt");

        assertArrayEquals(intsArray, intsArray1);
    }

    @Test
    public void serializeToByteBufferTest() throws TraineeException, IOException {
        Trainee trainee = new Trainee("Andrew", "Chmerenko", 5);
        ByteBuffer bb = NioProcessor.serializeToByteBuffer(trainee);

        Trainee trainee1 = NioProcessor.deserializeFromByteBuffer(bb);
        assertEquals(trainee, trainee1);
    }
}

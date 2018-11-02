package ru.omsu.imit.course3.main.nio;

import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioReader {
    public static Trainee byteBufferReader(String filePath) throws IOException, TraineeException {
        try(FileChannel fc = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ)){
            ByteBuffer bb = ByteBuffer.allocate((int) fc.size());
            fc.read(bb);
            String[] params = new String(bb.array(), "US-ASCII").split(" ");
            return new Trainee(params[0], params[1], Integer.parseInt(params[2]));
        }
    }
}

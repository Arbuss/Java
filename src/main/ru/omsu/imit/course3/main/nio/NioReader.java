package ru.omsu.imit.course3.main.nio;

import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioReader {
    public static Trainee byteBufferReader(String filePath) throws IOException, TraineeException {
        try(FileChannel fc = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ)){
            ByteBuffer bb = ByteBuffer.allocate((int) fc.size());
            fc.read(bb);
            String[] params = new String(bb.array(), StandardCharsets.UTF_8).split(" ");
            return new Trainee(params[0], params[1], Integer.parseInt(params[2]));
        }
    }

    public static Trainee mappedByteBufferReader(String filePath) throws IOException, TraineeException {
        try(FileChannel fc = new RandomAccessFile(new File(filePath), "rw").getChannel()){
            MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            byte[] bytes = new byte[(int)fc.size()];
            buffer.get(bytes);
            String[] params = new String(bytes, StandardCharsets.UTF_8).trim().split(" ");
            return new Trainee(params[0], params[1], Integer.parseInt(params[2]));
        }
    }
}

package ru.omsu.imit.course3.main.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioWriter {
    public static void mappedByteBufferWrite(String filePath, int... nums) throws IOException {
        try(FileChannel fc = FileChannel.open(Paths.get(filePath), new StandardOpenOption[]{StandardOpenOption.CREATE,
                StandardOpenOption.WRITE, StandardOpenOption.READ}))
        {
            MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, nums.length);

            for(int i: nums){
                buffer.put((byte)i);
                buffer.force();
            }
        }
    }
}

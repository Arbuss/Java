package ru.omsu.imit.course3.main.first_task.rectangle;

import ru.omsu.imit.course3.main.first_task.rectangle.*;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RectangleInput {
    private static double readByPosition(RandomAccessFile raf, long pos) throws IOException {
        raf.seek(pos);
        return raf.readDouble();
    }

    public static Rectangle rectangleRead(Rectangle rectangle, String filePath) throws IOException {
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))){
            double db1 = dis.readDouble();
            double db2 = dis.readDouble();
            double db3 = dis.readDouble();
            double db4 = dis.readDouble();

            return new Rectangle(db1, db2, db3, db4);
        }
    }

    public static Rectangle[] rectangleReadToArray(String filePath) throws IOException {
        Rectangle[] rectanglesArray = new Rectangle[5];
        try(RandomAccessFile raf = new RandomAccessFile(filePath, "r")){
            long len = raf.length();
            for(int i = 0; i < 5; i++){
                rectanglesArray[i] = new Rectangle(
                        readByPosition(raf, len -= 8),
                        readByPosition(raf, len -= 8),
                        readByPosition(raf, len -= 8),
                        readByPosition(raf, len -= 8)
                );
            }
            return rectanglesArray;
        }
    }
}

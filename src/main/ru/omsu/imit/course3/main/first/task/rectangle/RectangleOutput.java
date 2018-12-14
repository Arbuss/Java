package ru.omsu.imit.course3.main.first.task.rectangle;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RectangleOutput {
    public static void rectangleWrite(String filePath, Rectangle... rectanglesArray) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (Rectangle rec : rectanglesArray) {
                dos.writeDouble(rec.getLeftTop().x);
                dos.writeDouble(rec.getLeftTop().y);
                dos.writeDouble(rec.getRightBottom().x);
                dos.writeDouble(rec.getRightBottom().y);
            }
        }
    }

    public static void rectanglesToPrintStream(Rectangle[] rectanglesArray){
        try(PrintStream ps = new PrintStream(System.out)) {
            for (int i = 0; i < rectanglesArray.length; i++) {
                ps.printf("point[%d] = {%.1f; %.1f; %.1f; %.1f} \n", i,
                        rectanglesArray[i].getLeftTop().x,
                        rectanglesArray[i].getLeftTop().y,
                        rectanglesArray[i].getRightBottom().x,
                        rectanglesArray[i].getRightBottom().y);
            }
        }
    }
}

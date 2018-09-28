package src.ru.omsu.imit.course3.test.firstTask;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import src.ru.omsu.imit.course3.main.firstTask.Rectangle;

import java.io.*;

public class WriteTest {
    @Test
    public void rectangleWriteTest(){
        Rectangle rectangle = new Rectangle(2, 4, 6, 8);

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("files//rectangles.bin"))){
            dos.writeDouble(rectangle.getLeftTop().x);
            dos.writeDouble(rectangle.getLeftTop().y);
            dos.writeDouble(rectangle.getRightBottom().x);
            dos.writeDouble(rectangle.getRightBottom().y);
        }
        catch (IOException e){
            System.out.println("fail dos");
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream("files//rectangles.bin"))){
            double db1 = dis.readDouble();
            double db2 = dis.readDouble();
            double db3 = dis.readDouble();
            double db4 = dis.readDouble();

            Rectangle rectangle1 = new Rectangle(db1,  db2, db3, db4);

            assertEquals(2.0, rectangle1.getLeftTop().x, 0.0);
            assertEquals(4.0, rectangle1.getLeftTop().y, 0.0);
            assertEquals(6.0, rectangle1.getRightBottom().x, 0.0);
            assertEquals(8.0, rectangle1.getRightBottom().y, 0.0);
        }
        catch (IOException e){
            System.out.println("fail dis");
        }
    }

    @Test
    public void rectangleWriteTest1(){
        Rectangle[] rectanglesArray = {new Rectangle(1.1, 1.2, 1.3, 1.4),
                new Rectangle(2.1, 2.2, 2.3, 2.4),
                new Rectangle(3.1, 3.2, 3.3, 3.4),
                new Rectangle(4.1, 4.2, 4.3, 4.4),
                new Rectangle(5.1, 5.2, 5.3, 5.4),
        };

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("files//rectangles.bin"))){
            for(Rectangle rec: rectanglesArray){
                dos.writeDouble(rec.getLeftTop().x);
                dos.writeDouble(rec.getLeftTop().y);
                dos.writeDouble(rec.getRightBottom().x);
                dos.writeDouble(rec.getRightBottom().y);
            }
        }
        catch(IOException e){
            System.out.println("fail task10");
        }

        try(RandomAccessFile raf = new RandomAccessFile("files//rectangles.bin", "r")){
            for(int i = 0; i < 5; i++){
                rectanglesArray[i].setLeftTop();
                rectanglesArray[i].setRightBottom();
            }
        }
        catch (IOException e){
            System.out.println("fail task10.2");
        }
    }
}

package src.ru.omsu.imit.course3.test.firstTask;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import src.ru.omsu.imit.course3.main.firstTask.*;

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
            long len = raf.length();
            for(int i = 0; i < 5; i++){
                rectanglesArray[i].setLeftTop(new Point2D(StaticMethods.readByPosition(raf, len -= 8),
                        StaticMethods.readByPosition(raf, len -= 8)));
                rectanglesArray[i].setRightBottom(new Point2D(StaticMethods.readByPosition(raf, len -= 8),
                        StaticMethods.readByPosition(raf, len -= 8)));
            }
        }
        catch (IOException e){
            System.out.println("fail task10.2");
        }


        /*try(PrintStream ps = new PrintStream(System.out))
        {
            for(int i = 0; i < rectanglesArray.length; i++) {
                ps.printf("point[%d] = {%.1f; %.1f; %.1f; %.1f} \n", i,
                        rectanglesArray[i].getLeftTop().x,
                        rectanglesArray[i].getLeftTop().y,
                        rectanglesArray[i].getRightBottom().x,
                        rectanglesArray[i].getRightBottom().y);
            }
        }
        catch(Exception ex){
            System.err.print("err in PrintStreamTest");
        }*/

        try(FileOutputStream fos = new FileOutputStream("files//trainee.txt");
            PrintStream ps = new PrintStream(fos))
        {
            Trainee trainee = new Trainee("Андрей", "Чмеренко", 5);
            ps.printf("%s \n%s \n%d", trainee.getFirstName(), trainee.getSecondName(), trainee.getMark());
        }
        catch(Exception ex){
            System.err.print("err in FileOutput+PrintStreamTest");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("files//trainee.txt"))){
            String fn = br.readLine();
            String ln = br.readLine();
            int mark = Integer.parseInt(br.readLine());
            Trainee trainee = new Trainee(fn, ln, mark);
        }
        catch (IOException | TraineeException e){
            System.err.println(e.getMessage());
        }

        try(FileOutputStream fos = new FileOutputStream("files//trainee.txt");
            PrintStream ps = new PrintStream(fos))
        {
            Trainee trainee = new Trainee("Андрей", "Чмеренко", 5);
            ps.printf("%s %s %d", trainee.getFirstName(), trainee.getSecondName(), trainee.getMark());
        }
        catch(Exception ex){
            System.err.print("err in FileOutput+PrintStreamTest");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("files//trainee.txt"))){
            String str = br.readLine().trim();
            String[] nStr = str.split(" ");

            Trainee trainee = new Trainee(nStr[0], nStr[1], Integer.parseInt(nStr[2]));
        }
        catch (IOException | TraineeException e){
            System.err.println(e.getMessage());
        }
    }
}

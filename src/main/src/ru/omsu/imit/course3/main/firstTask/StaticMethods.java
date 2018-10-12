package src.ru.omsu.imit.course3.main.firstTask;

import com.google.gson.Gson;

import java.io.*;

public class StaticMethods {
    public static double readByPosition(RandomAccessFile raf, long pos){
        try{
            raf.seek(pos);
            return raf.readDouble();
        }
        catch(IOException e){
            System.err.println("err in readByPosition");
        }
        return 0;
    }

    public static Rectangle rectangleWriteAndRead(Rectangle rectangle){
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

            return new Rectangle(db1,  db2, db3, db4);
        }
        catch (IOException e){
            System.out.println("fail dis");
        }
        return null;
    }

    public static Rectangle[] rectangleWriteAndRead2(Rectangle[] rectanglesArray){
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

            return rectanglesArray;
        }
        catch (IOException e){
            System.out.println("fail task10.2");
        }

        try(PrintStream ps = new PrintStream(System.out))
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
        }

        return null;
    }

    public static void traineeWrite(Trainee trainee){

        try(FileOutputStream fos = new FileOutputStream("files//trainee.txt");
            PrintStream ps = new PrintStream(fos))
        {
            ps.printf("%s \n%s \n%d", trainee.getFirstName(), trainee.getSecondName(), trainee.getMark());
        }
        catch(Exception ex){
            System.err.print("err in FileOutput+PrintStreamTest");
        }
    }

    public static Trainee traineeRead(){
        try(BufferedReader br = new BufferedReader(new FileReader("files//trainee.txt"))){
            String fn = br.readLine();
            String ln = br.readLine();
            int mark = Integer.parseInt(br.readLine());
            return new Trainee(fn, ln, mark);
        }
        catch (IOException | TraineeException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void traineeWrite2(Trainee trainee){
        try(FileOutputStream fos = new FileOutputStream("files//trainee.txt");
            PrintStream ps = new PrintStream(fos))
        {
            ps.printf("%s %s %d", trainee.getFirstName(), trainee.getSecondName(), trainee.getMark());
        }
        catch(Exception ex){
            System.err.print("err in FileOutput+PrintStreamTest");
        }
    }

    public static Trainee traineeRead2(){
        try(BufferedReader br = new BufferedReader(new FileReader("files//trainee.txt"))){
            String str = br.readLine().trim();
            String[] nStr = str.split(" ");

            return new Trainee(nStr[0], nStr[1], Integer.parseInt(nStr[2]));
        }
        catch (IOException | TraineeException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static String serialize(Trainee trainee){
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static void serializeWrite(String json){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("files//serialize.bin"))){
            dos.writeUTF(json);
        }
        catch (IOException e){
            System.out.println("fail dos");
        }
    }

    public static Trainee serializeRead(){
        try(BufferedReader br = new BufferedReader(new FileReader("files//serialize.bin"))){
            br.read(new char[2], 0, 2);
            String json = br.readLine();
            Gson gson = new Gson();
            return gson.fromJson(json, Trainee.class);
        }
        catch (IOException e){
            System.err.println("serializeRead fail");
        }
        return null;
    }
}

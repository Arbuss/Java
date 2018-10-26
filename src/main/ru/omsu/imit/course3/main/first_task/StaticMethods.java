package ru.omsu.imit.course3.main.first_task;

import com.google.gson.Gson;

import java.io.*;

public class StaticMethods {
    public static double readByPosition(RandomAccessFile raf, long pos) throws IOException {
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

    public static Rectangle[] rectangleReadToArray(String filePath) throws IOException {
        Rectangle[] rectanglesArray = new Rectangle[5];
        try(RandomAccessFile raf = new RandomAccessFile(filePath, "r")){
            long len = raf.length();
            for(int i = 0; i < 5; i++){
                rectanglesArray[i] = new Rectangle(
                        StaticMethods.readByPosition(raf, len -= 8),
                        StaticMethods.readByPosition(raf, len -= 8),
                        StaticMethods.readByPosition(raf, len -= 8),
                        StaticMethods.readByPosition(raf, len -= 8)
                );
            }
            return rectanglesArray;
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

    public static void traineeWriteWithLineSeparation(Trainee trainee, String filePath) throws FileNotFoundException, IOException {
        try(FileOutputStream fos = new FileOutputStream(filePath);
            PrintStream ps = new PrintStream(fos))
        {
            ps.printf("%s\n%s\n%d", trainee.getFirstName(), trainee.getSecondName(), trainee.getMark());
        }
    }

    public static Trainee traineeRead(String filePath) throws TraineeException, IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String fn = br.readLine();
            String ln = br.readLine();
            int mark = Integer.parseInt(br.readLine());
            return new Trainee(fn, ln, mark);
        }
    }

    public static void traineeWrite(Trainee trainee, String filePath) throws IOException{
        try(FileOutputStream fos = new FileOutputStream(filePath);
            PrintStream ps = new PrintStream(fos))
        {
            ps.printf("%s %s %d", trainee.getFirstName(), trainee.getSecondName(), trainee.getMark());
        }
    }

    public static Trainee traineeRead2(String filePath) throws IOException, TraineeException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String str = br.readLine().trim();
            String[] nStr = str.split(" ");
            return new Trainee(nStr[0], nStr[1], Integer.parseInt(nStr[2]));
        }
    }

    public static String serialize(Trainee trainee){
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static void serializeWrite(String json, String filePath) throws IOException{
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))){
            dos.writeUTF(json);
        }
    }

    public static Trainee serializeRead(String filePath) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.read(new char[2], 0, 2);
            String json = br.readLine();
            Gson gson = new Gson();
            return gson.fromJson(json, Trainee.class);
        }
    }

    public static void ByteArrayOutputStreamSerialization(Trainee trainee, String filePath) throws IOException{
        String str = serialize(trainee);
        byte[] buffer = str.getBytes();

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            baos.write(buffer);
            baos.writeTo(new FileOutputStream(filePath));
        }
    }

    public static void ByteArrayInputStreamDeserialization(String filePath) throws IOException, ClassNotFoundException {
        byte[] buffer;

        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))){
            int len = dis.available();
            buffer = new byte[len];
            for(int i = 0; i < len; i++){
                buffer[i] = dis.readByte();
            }


        }

    }


}

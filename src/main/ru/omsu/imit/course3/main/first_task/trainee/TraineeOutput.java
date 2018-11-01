package ru.omsu.imit.course3.main.first_task.trainee;

import com.google.gson.Gson;

import java.io.*;

public class TraineeOutput {
    public static void traineeWriteWithLineSeparation(Trainee trainee, String filePath) throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             PrintStream ps = new PrintStream(fos)) {
            ps.printf("%s\n%s\n%d", trainee.getFirstName(), trainee.getSecondName(), trainee.getMark());
        }
    }

    public static void traineeWrite(Trainee trainee, String filePath) throws IOException {
        try (PrintStream ps = new PrintStream(new FileOutputStream(filePath))){
            ps.printf("%s %s %d", trainee.getFirstName(), trainee.getSecondName(), trainee.getMark());
        }
    }

    public static void serializeWrite(Trainee trainee, String filePath) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            byte[] firstName = trainee.getFirstName().getBytes();
            byte[] secondName = trainee.getSecondName().getBytes();
            byte mark = (byte) trainee.getMark();

            dos.write(firstName.length);
            dos.write(firstName);
            dos.write(secondName.length);
            dos.write(secondName);
            dos.write(mark);
        }
    }

    public static void ByteArrayOutputStreamSerialize(Trainee trainee, String filePath) throws IOException {
        byte[] firstName = trainee.getFirstName().getBytes();
        byte[] secondName = trainee.getSecondName().getBytes();
        byte mark = (byte) trainee.getMark();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write(firstName.length);
            baos.write(firstName);
            baos.write(secondName.length);
            baos.write(secondName);
            baos.write(mark);
            baos.writeTo(new FileOutputStream(filePath));
        }
    }

    public static String serializeByGson(Trainee trainee){
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static void serializeByGson(Trainee trainee, String filePath) throws IOException {
        String json = serializeByGson(trainee);
        try (PrintStream ps = new PrintStream(new FileOutputStream(filePath))) {
            ps.print(json);
        }
    }
}

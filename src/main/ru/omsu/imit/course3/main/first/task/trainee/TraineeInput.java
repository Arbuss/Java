package ru.omsu.imit.course3.main.first.task.trainee;

import com.google.gson.Gson;

import java.io.*;

public class TraineeInput {
    public static Trainee traineeRead(String filePath) throws TraineeException, IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String fn = br.readLine();
            String ln = br.readLine();
            int mark = Integer.parseInt(br.readLine());
            return new Trainee(fn, ln, mark);
        }
    }

    public static Trainee traineeRead2(String filePath) throws IOException, TraineeException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String str = br.readLine().trim();
            String[] nStr = str.split(" ");
            return new Trainee(nStr[0], nStr[1], Integer.parseInt(nStr[2]));
        }
    }

    public static Trainee serializeRead(String filePath) throws IOException, TraineeException {
        String firstName;
        String secondName;
        int mark;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            int len = br.read();
            char[] array = new char[len];
            br.read(array, 0, len);
            firstName = new String(array);

            len = br.read();
            array = new char[len];
            br.read(array, 0, len);
            secondName = new String(array);

            mark = br.read();
        }

        return new Trainee(firstName, secondName, mark);
    }

    public static Trainee byteArrayInputStreamDeserialize(String filePath) throws IOException, TraineeException {
        byte[] buffer;

        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))){
            int len = dis.available();
            buffer = new byte[len];
            for(int i = 0; i < len; i++){
                buffer[i] = dis.readByte();
            }
        }

        String firstName;
        String secondName;
        int mark;
        try(ByteArrayInputStream bais = new ByteArrayInputStream(buffer)){
            int len = bais.read();
            byte[] byteArray = new byte[len];
            bais.read(byteArray, 0, len);
            firstName = new String(byteArray);

            len = bais.read();
            byteArray = new byte[len];
            bais.read(byteArray, 0, len);
            secondName = new String(byteArray);

            mark = bais.read();
        }

        return new Trainee(firstName, secondName, mark);
    }

    public static Trainee deserializeFromGson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static Trainee deserializeByGson(String filePath) throws IOException {
        String json;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            json = br.readLine();
        }
        return deserializeFromGson(json);
    }
}

package ru.omsu.imit.course3.main.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileTestMethods {
    public static byte[] readToOutputStream(String filePath) throws IOException {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(Paths.get(filePath), baos);
            return baos.toByteArray();
        }
    }

    public static void writeToFile(String filePath, String src) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.write(src.getBytes());
        }
    }

    public static void copyFile(String fileSrc, String fileDest) throws IOException {
        if(Files.notExists(Paths.get(fileDest))){
            Files.copy(Paths.get(fileSrc), Paths.get(fileDest));
        }
        /*else
            throw new FileAlreadyExistsException(fileDest);*/
    }

    public static byte[] readFromFile(String filePath) throws IOException {
        byte[] buffer;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))){
            int len = dis.available();
            buffer = new byte[len];
            for(int i = 0; i < len; i++){
                buffer[i] = dis.readByte();
            }
            return buffer;
        }
    }

    public static void renameAllFiles(String dir) throws IOException {
        Iterator<Path> iterator = Files.newDirectoryStream(Paths.get(dir)).iterator();
        iterator.forEachRemaining((i) -> {
            String fileName = dir + "\\" +i.getFileName();
            if(fileName.substring(fileName.indexOf('.')).equals("dat")) {
                try {
                    Files.move(Paths.get(fileName),
                            Paths.get(fileName.substring(0, fileName.length() - 3) + "bin"));
                } catch (IOException ignored) {
                }
            }
        });

    }
}

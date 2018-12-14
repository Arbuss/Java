package ru.omsu.imit.course3.main.first.task.file_check;

import java.io.File;
import java.io.IOException;

public class FileCheck {
    public static void main(String[] args) throws IOException {
        //Файлы
        File file = new File("src//main//ru//omsu//imit//course3//main//first_task//file_check//dir//file.txt");

        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        if(!file.exists())
            System.out.println(file.createNewFile());
        else
            System.out.println(true);
        file.renameTo(new File("src//main//ru//omsu//imit//course3//main//first_task//file_check//dir//newName"));
        System.out.println(file.isFile());
        file.delete();

        //Каталоги
        File dir = new File("src//main//ru//omsu//imit//course3//main//first_task//file_check//dir");

        if(!dir.exists())
            dir.mkdir();
        System.out.println(dir.isDirectory());
        System.out.println(dir.getName());
        System.out.println(dir.getAbsolutePath());

        if(dir.isDirectory()){
            for(File item : dir.listFiles()){
                if(item.isDirectory()){
                    System.out.println(item.getName() + "  \t folder");
                }
                else{
                    System.out.println(item.getName() + "\t file");
                }
            }
        }

        dir.renameTo(new File( "src//main//ru//omsu//imit//course3//main//first_task//file_check//newDir"));
        dir.delete();



    }
}

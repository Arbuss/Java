package ru.omsu.imit.course3.test.nio;

import org.junit.Test;
import ru.omsu.imit.course3.main.nio.FileTestMethods;

import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

public class FileTest {
    @Test
    public void creatorsTest() throws IOException {
        if(Files.notExists(Paths.get("files\\files_test")))
            Files.createDirectory(Paths.get("files\\files_test"));
        else
            assertTrue(Files.exists(Paths.get("files\\files_test")));

        if(Files.notExists(Paths.get("files\\files_test\\hydrometeois.dat")))
            Files.createFile(Paths.get("files\\files_test\\hydrometeois.dat"));
        else
            assertTrue(Files.exists(Paths.get("files\\files_test\\hydrometeois.dat")));
    }

    @Test
    public void copyTest() throws IOException{
        String res = "copy test";
        FileTestMethods.writeToFile("files\\files_test\\readTest", res);
        FileTestMethods.copyFile("files\\files_test\\readTest", "files\\files_test2\\readTestCopy");
        byte[] strBytes = FileTestMethods.readFromFile("files\\files_test2\\readTestCopy");


        assertArrayEquals(strBytes, FileTestMethods.readToOutputStream("files\\files_test2\\readTestCopy"));
    }

    @Test
    public void delete() throws IOException {
        Files.deleteIfExists(Paths.get("files\\files_test\\toDel"));
        assertFalse(Files.exists(Paths.get("files\\files_test\\toDel")));
    }

    @Test
    public void sameFile() throws IOException {
        assertTrue(Files.isSameFile(Paths.get("files\\files_test\\readTest"),
                Paths.get("files\\files_test\\readTest")));
        assertFalse(Files.isSameFile(Paths.get("files\\files_test\\readTest"),
                Paths.get("files\\files_test\\hydrometeois.dat")));
    }

    @Test
    public void moveTest() throws IOException {
        if(Files.exists(Paths.get("files\\files_test\\toMove")))
            Files.move(Paths.get("files\\filess_test\\toMove"),
                Paths.get("files\\files_test2\\toMove"));
        assertTrue(Files.exists(Paths.get("files\\files_test2\\toMove")));
    }

    @Test
    public void renameTest() throws IOException {
        String dir = "files\\files_test3";
        FileTestMethods.renameAllFiles(dir);

        Iterator<Path> iterator = Files.newDirectoryStream(Paths.get(dir)).iterator();
        iterator.forEachRemaining((i) ->{
            String fileName = i.getFileName().toString();
            if(fileName.substring(fileName.indexOf('.')).equals("dat"))
                assertEquals(fileName.substring(0, fileName.length() - 3) + "bin", fileName);
        });
    }
}

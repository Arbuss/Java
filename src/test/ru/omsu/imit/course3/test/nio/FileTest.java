package ru.omsu.imit.course3.test.nio;

import org.junit.Test;

import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
}

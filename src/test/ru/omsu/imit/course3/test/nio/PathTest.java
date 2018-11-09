package ru.omsu.imit.course3.test.nio;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class PathTest {
    @Test
    public void gettersTest(){
        Path path1 = Paths.get("files");
        Path absPath = path1.toAbsolutePath();
        Path path2 = Paths.get("src\\main\\ru");

        assertEquals("files", path1.toString());
        assertEquals("C:\\Проекты студентов и преподавателей\\3 курс\\Buss\\course3-1\\files",
                absPath.toString());
        assertEquals("3 курс", absPath.getName(1).toString());
        assertEquals("src", path2.getParent().getName(0).toString());
        assertEquals(3, path2.getNameCount());
        assertEquals("C:\\", absPath.getRoot().toString());

        assertNull(path1.getRoot());
        assertTrue(path2.endsWith(Paths.get("ru")));
        assertTrue(path2.endsWith("ru"));
    }
}

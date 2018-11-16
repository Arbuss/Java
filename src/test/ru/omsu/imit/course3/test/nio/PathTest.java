package ru.omsu.imit.course3.test.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class PathTest {
    @Test
    public void gettersTest() throws IOException {
        Path path1 = Paths.get("files");
        Path path2 = Paths.get("src\\main\\ru");
        Path path3 = Paths.get("src\\main");
        Path path4 = Paths.get("src\\main");
        Path path5 = Paths.get("ru");
        Path path6 = Paths.get("./files\\Nio.txt");
        Path absPath = path1.toAbsolutePath();

        assertEquals("files", path1.toString());
        assertEquals("C:\\Проекты студентов и преподавателей\\3 курс\\Buss\\course3-1\\files",
                absPath.toString());
        assertEquals("3 курс", absPath.getName(1).toString());
        assertEquals("src", path2.getParent().getName(0).toString());
        assertEquals(3, path2.getNameCount());
        assertEquals("C:\\", absPath.getRoot().toString());
        assertEquals(0, path3.compareTo(path4));
        assertEquals("ru", path2.getFileName().toString());
        assertEquals("files\\Nio.txt" ,path6.normalize().toString());
        assertEquals("C:\\Проекты студентов и преподавателей\\3 курс\\Buss\\course3-1\\files",
                absPath.toRealPath(LinkOption.NOFOLLOW_LINKS).toString());

        assertFalse(path1.isAbsolute());
        assertTrue(path2.endsWith(path5));
        assertTrue(path2.endsWith("ru"));
        assertTrue(path2.compareTo(path3) > 0);
        assertTrue(path3.compareTo(path2) < 0);
        assertNull(path1.getRoot());
        assertTrue(path2.endsWith(Paths.get("ru")));
        assertTrue(path2.endsWith("ru"));
    }
}

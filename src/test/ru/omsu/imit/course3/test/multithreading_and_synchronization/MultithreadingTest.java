package ru.omsu.imit.course3.test.multithreading_and_synchronization;

import org.junit.Test;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.ThreadProcessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultithreadingTest {
    @Test
    public void getPropertiesTest(){
        assertEquals("Thread[main,5,main]", ThreadProcessor.getAllProperties());
    }

    @Test
    public void createAndWaitTest(){
        assertEquals("thread finished", ThreadProcessor.createAndWaitNewThread());
    }

    @Test
    public void createAndWaitThreeNewThreadsTest(){
        assertEquals("All threads finished", ThreadProcessor.createAndWaitThreeNewThreads());
    }

    @Test
    public void addAndDelListElems(){
        ThreadProcessor.addAndDelListElems();
    }

    @Test
    public void addAndDelListElems2(){
        ThreadProcessor.addAndDelListElems2();
    }

    @Test
    public void addAndDelListElems3(){
        ThreadProcessor.addAndDelListElems3();
    }

    @Test
    public void pingPongTest(){
        ThreadProcessor.pingPong();
    }

    @Test
    public void writerReaderTest(){
        ThreadProcessor.readerWriter();
    }

    @Test
    public void addAndDelReentrant(){
        ThreadProcessor.addAndDelReentrant();
    }

    @Test
    public void pingPongReentrantTest(){
        ThreadProcessor.pingPongReentrant();
    }

    @Test
    public void concurrentHashMapTest(){
        ThreadProcessor.concurrentHashMapThreadsTest();
    }

    @Test
    public void formatterTest(){
        ThreadProcessor.formatter();
    }
}

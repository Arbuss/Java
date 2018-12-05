package ru.omsu.imit.course3.main.multithreading_and_synchronization;

import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.ThreadsConstants;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.eight_task_threads.Book;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.eight_task_threads.Reader;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.eight_task_threads.Writer;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.eleven_task_threads.PingPong2;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.five_task_threads.AddDelThread;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.four_task_threads.AddClass;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.four_task_threads.DelClass;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.seven_task_threads.Ping;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.seven_task_threads.PingPong;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.seven_task_threads.Pong;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.six_task_threads.AddAndDelThreadSynchList;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.three_task_threads.Thread1;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.three_task_threads.Thread2;
import ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.three_task_threads.Thread3;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

import static ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.ThreadsConstants.TEST_NUM_FOR_TASK;

public class ThreadProcessor {
    public static String getAllProperties(){
        return Thread.currentThread().toString();
    }

    public static String createAndWaitNewThread(){
        Thread thread = new Thread();
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.printf("%s has been interrupted", thread.getName());
        }
        return "thread finished";
    }

    public static String createAndWaitThreeNewThreads(){
        Thread1 thread1 = new Thread1("thread1");
        Thread2 thread2 = new Thread2("thread2");
        Thread3 thread3 = new Thread3("thread3");

        thread1.start();
        thread1.run();
        thread2.start();
        thread2.run();
        thread3.start();
        thread3.run();

        return "All threads finished";
    }

    public static void addAndDelListElems(){
        List<Integer> list = new ArrayList();

        AddClass add = new AddClass(list);
        DelClass del = new DelClass(list);

        add.run();
        del.run();
    }

    public static void addAndDelListElems2(){
        List<Integer> list = new ArrayList();

        AddDelThread addDelThread = new AddDelThread(list);
        AddDelThread addDelThread2 = new AddDelThread(list);
        //addDelThread.run();

        addDelThread.start();
        addDelThread2.start();
        addDelThread.add();
        addDelThread2.del();
    }

    public static void addAndDelListElems3(){
        List<Integer> list = new ArrayList();
        AddAndDelThreadSynchList thread = new AddAndDelThreadSynchList(Collections.synchronizedList(list));

        thread.run();
    }

    public static void pingPong(){
        PingPong pingPong = new PingPong();
        Ping ping = new Ping(pingPong);
        Pong pong= new Pong(pingPong);
        new Thread(ping).start();
        new Thread(pong).start();
    }

    public static void readerWriter(){
        Book book = new Book();
        Writer writer = new Writer(book);
        Reader reader = new Reader(book);

        new Thread(writer).start();
        new Thread(reader).start();
    }

    public static void addAndDelReentrant(){
        ReentrantLock locker = new ReentrantLock();

        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        Thread thread1 = new Thread(() -> {
            locker.lock();
            for (int i = 0; i < TEST_NUM_FOR_TASK; i++)
                list.add(i);
            System.out.println("add fin");
            locker.unlock();
        });

        Thread thread2 = new Thread(() -> {
            locker.lock();
            try {
                for (int i = 0; i < TEST_NUM_FOR_TASK; i++)
                    list.remove(random.nextInt(TEST_NUM_FOR_TASK));
            } catch(IndexOutOfBoundsException e){ }
            finally {
                System.out.println("del fin");
                locker.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void pingPongReentrant(){
        PingPong2 pingPong2 = new PingPong2();
        Thread thread1 = new Thread(() -> {
            while(true)
                pingPong2.ping();
        });

        Thread thread2 = new Thread(() -> {
            while(true)
                pingPong2.pong();
        });

        thread1.start();
        thread2.start();
    }

    public static void concurrentHashMapThreadsTest(){
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        Random rnd = new Random();

        Thread adder = new Thread(() -> {
            for(int i = 0; i < TEST_NUM_FOR_TASK / 100; i++)
                map.add(i, Integer.toString(i));
        });

        Thread reader = new Thread(() -> {
            try {
                for (int i = 0; i < TEST_NUM_FOR_TASK / 100; i++)
                    map.get(i);
            } catch(NoSuchElementException el){}
        });

        Thread randomReader = new Thread(() -> {
            for(int i = 0; i < 100; i++)
                map.get(rnd.nextInt(TEST_NUM_FOR_TASK));
        });

        adder.start();
        randomReader.start();
        reader.start();
    }

    public static void formatter(){
        Formatter formatter = new Formatter();
        Date date = new Date();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1: " + formatter.format(date));
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2: " + formatter.format(date));
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("Thread3: " + formatter.format(date));
        });

        Thread thread4 = new Thread(() -> {
            System.out.println("Thread4: " + formatter.format(date));
        });

        Thread thread5 = new Thread(() -> {
            System.out.println("Thread5: " + formatter.format(date));
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

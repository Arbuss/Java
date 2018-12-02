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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
}

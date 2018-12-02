package ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.eleven_task_threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong2 {
    ReentrantLock locker;
    Condition condition;

    boolean ping = true;
    boolean pong = true;

    public PingPong2(){
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void ping(){
        locker.lock();
        if (!ping) {
            try {
                condition.await();
            }
            catch (InterruptedException e) {
            }
            ping = true;
        }
        System.out.println("ping");
        ping = false;
        condition.signalAll();
    }

    public void pong(){
        locker.lock();
        if (!pong) {
            try {
                condition.await();
            }
            catch (InterruptedException e) {
            }
            pong = true;
        }
        System.out.println("pong");
        pong = false;
        condition.signalAll();
    }
}

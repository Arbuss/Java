package ru.omsu.imit.course3.main.multithreading_and_synchronization.threads.seven_task_threads;

public class PingPong {

    private boolean ping = true;
    private boolean pong = true;

    public synchronized void ping() {
        if (!ping) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
            ping = true;
        }
        System.out.println("ping");
        ping = false;
        notifyAll();
    }

    public synchronized void pong() {
        if (!pong) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
            pong = true;
        }
        System.out.println("pong");
        pong = false;
        notifyAll();
    }
}

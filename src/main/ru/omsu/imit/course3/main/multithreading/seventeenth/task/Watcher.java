package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;

public class Watcher extends Thread{
    private Executor[] executors;

    public Watcher(Executor ... executors){
        this.executors = executors;
    }

    public void watch() {
        try (BufferedOutputStream bos = new BufferedOutputStream(System.out)) {
            while (true) {
                for (Executor executor : executors) {
                    if (executor.isAlive()) {
                        try {
                            String name = executor.getTaskName();
                            int sNum = executor.getStageNumber();
                            int sCount = executor.getStagesCount();
                            bos.write(name.getBytes());
                            bos.write(sNum);
                            bos.write(sCount);
                        } catch (NullPointerException npe) {

                        } catch (BufferOverflowException boe) {
                            bos.flush();
                        }
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            watch();
        }
    }
}

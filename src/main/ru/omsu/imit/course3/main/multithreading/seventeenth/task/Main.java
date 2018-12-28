package ru.omsu.imit.course3.main.multithreading.seventeenth.task;

import org.apache.commons.cli.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static int MULTISTAGE_TASK_COUNT = 5;
    public static volatile AtomicInteger taskCount = new AtomicInteger(0);

    public static void main(String[] args) throws ParseException {
        Option dCount = new Option("d", "developers", true, "кол-во разработчиков");
        Option eCount = new Option("e", "executors", true, "кол-во исполнителей");
        Options options = new Options();
        options.addOption(dCount);
        options.addOption(eCount);

        CommandLineParser parser = new DefaultParser();
        CommandLine line = parser.parse( options, args);

        int developersCount = -1;
        if(line.hasOption("d")){
            developersCount = Integer.parseInt(line.getOptionValue("d"));
        }

        int executorsCount = -1;
        if(line.hasOption("e")){
            executorsCount = Integer.parseInt(line.getOptionValue("e"));
        }

        if(developersCount == -1){
            developersCount = 2;
        }
        if(executorsCount == -1){
            executorsCount = 2;
        }

        ArrayBlockingQueue<MultistageTask> queue = new ArrayBlockingQueue(developersCount*5);
        Executor[] executors = new Executor[executorsCount];
        Developer[] developers = new Developer[developersCount];

        for(int i = 0; i < executorsCount; i++){
            executors[i] = new Executor(queue);
        }

        for(int i = 0; i < developersCount; i++){
            developers[i] = new Developer(queue);
        }

        Watcher watcher = new Watcher(queue);

        for(Developer developer: developers){
            developer.start();
        }

        for(Executor executor: executors){
            executor.start();
        }
        
        watcher.start();
    }
}

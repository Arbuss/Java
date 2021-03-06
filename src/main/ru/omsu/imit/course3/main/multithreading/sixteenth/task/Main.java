package ru.omsu.imit.course3.main.multithreading.sixteenth.task;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        TaskQueue queue = new TaskQueue(16);

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

        Executor[] executors = new Executor[executorsCount];
        Developer[] developers = new Developer[developersCount];

        for(int i = 0; i < executorsCount; i++){
            executors[i] = new Executor(queue, 10);
        }

        for(int i = 0; i < developersCount; i++){
            developers[i] = new Developer(queue, 10);
        }

        for(Developer developer: developers){
            developer.run();
        }

        for(Executor executor: executors){
            executor.run();
        }

        for(Developer developer: developers){
            try {
                developer.join();
            } catch (InterruptedException e) {

            }
        }

        for(int i = 0; i < developers.length; i++) {
            try {
                queue.addPoison();
            } catch (InterruptedException e) {

            }
        }
    }
}

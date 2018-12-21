package ru.omsu.imit.course3.main.multithreading.fifteenth.task;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        DataQueue queue = new DataQueue(16);

        Option wCount = new Option("w", "writers", true, "кол-во писателей");
        Option rCount = new Option("r", "readers", true, "кол-во читателей");
        Options options = new Options();
        options.addOption(wCount);
        options.addOption(rCount);

        CommandLineParser parser = new DefaultParser();
        CommandLine line = parser.parse( options, args);

        int writersCount = -1;
        if(line.hasOption("w")){
            writersCount = Integer.parseInt(line.getOptionValue("w"));
        }

        int readersCount = -1;
        if(line.hasOption("r")){
            readersCount = Integer.parseInt(line.getOptionValue("r"));
        }

        if(writersCount == -1){
            writersCount = 2;
        }
        if(readersCount == -1){
            readersCount = 2;
        }

        Executors[] readers = new Executors[readersCount];
        Developer[] writers = new Developer[writersCount];

        for(int i = 0; i < readersCount; i++){
            readers[i] = new Executors(queue, 5);
        }

        for(int i = 0; i < writersCount; i++){
            writers[i] = new Developer(queue, 5);
        }

        for(Developer writer: writers){
            writer.start();
        }

        for(Executors reader: readers){
            reader.start();
        }


        for(Developer writer: writers){
            try {
                writer.join();
            } catch (InterruptedException e) {

            }
        }
        for(int i = 0; i < writers.length; i++) {
            try {
                queue.addPoison();
            } catch (InterruptedException e) {

            }
        }
    }
}

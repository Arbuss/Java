package ru.omsu.imit.course3.main.multithreading_and_synchronization.fifteen_task;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        DataQueue queue = new DataQueue();

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
            readers[i] = new Executors(queue);
        }

        for(int i = 0; i < writersCount; i++){
            writers[i] = new Developer(queue);
        }

        for(Developer writer: writers){
            writer.run();
        }

        for(Executors reader: readers){
            reader.run();
        }
    }
}

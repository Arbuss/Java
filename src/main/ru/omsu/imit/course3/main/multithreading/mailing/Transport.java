package ru.omsu.imit.course3.main.multithreading.mailing;

import java.io.*;

public class Transport {
    public static void send(Message message) throws TransportException {
        try(PrintStream ps = new PrintStream(new FileOutputStream(message.getEmail(), true))){
            synchronized (ps) {ps.println(message.getBody()); }
            Thread.sleep(1000);
        } catch (FileNotFoundException e) {
            throw new TransportException(TransportErrorCodes.SERVER_NULL.getErrorText());
        } catch (IOException | InterruptedException e) { }
    }
}

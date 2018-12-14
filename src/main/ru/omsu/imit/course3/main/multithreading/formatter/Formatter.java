package ru.omsu.imit.course3.main.multithreading.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
    public String format(Date date){
        ThreadLocal<Date> dateLocal = new ThreadLocal<>();
        dateLocal.set(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        return sdf.format(dateLocal.get());
    }
}

package src.ru.omsu.imit.course3.main.firstTask;

import java.io.IOException;
import java.io.RandomAccessFile;

public class StaticMethods {
    public static double readByPosition(RandomAccessFile raf, long pos){
        try{
            raf.seek(pos);
            return raf.readDouble();
        }
        catch(IOException e){
            System.err.println("err in readByPosition");
        }
        return 0;
    }
}

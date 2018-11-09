package ru.omsu.imit.course3.main.nio;

import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeInput;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeOutput;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class NioProcessor {
    public static ByteBuffer serializeToByteBuffer(Trainee trainee) throws IOException {
        int size = Integer.BYTES + trainee.getFirstName().getBytes().length + trainee.getSecondName().getBytes().length;
        String json = TraineeOutput.serializeByGson(trainee);
        ByteBuffer bb = ByteBuffer.allocate(json.getBytes().length);
        bb.put(json.getBytes());
        return bb;
    }

    public static Trainee deserializeFromByteBuffer(ByteBuffer bb){
        return TraineeInput.deserializeFromGson(new String(bb.array(), StandardCharsets.UTF_8));
    }
}

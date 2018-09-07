package src.ru.omsu.imit.cource3.test;

import src.ru.omsu.imit.cource3.main.Priorities;
import src.ru.omsu.imit.cource3.main.Task;
import org.junit.Test;
import src.ru.omsu.imit.cource3.main.TasksQueue;

import static org.junit.Assert.assertEquals;

public class TasksQueueTests {
    @Test
    public void constructorTest(){
    // Тест конструктора с произвольным кол-вом аргументов и сортировки по приоритетам
        Task t1 = new Task("first","13:21:04",Priorities.High_Real);
        Task t2 = new Task("second","13:22:05",Priorities.High_Real);
        Task t3 = new Task("third","13:21:04",Priorities.High);
        Task t4 = new Task("fourth","13:21:04",Priorities.Medium);

        TasksQueue tq = new TasksQueue(t4, t1, t2, t3);

        assertEquals(t1, tq.get());
        assertEquals(t2, tq.get());
        assertEquals(t3, tq.get());
        assertEquals(t4, tq.get());
    }

    @Test
    public void addTest(){
    // Тест на добавление элементов в очередь и очищение очереди
        Task t1 = new Task("first","13:21:04",Priorities.High_Real);
        Task t2 = new Task("second","13:22:05",Priorities.High_Real);
        Task t3 = new Task("third","13:21:04",Priorities.High);
        Task t4 = new Task("fourth","13:21:04",Priorities.Medium);

        TasksQueue tq = new TasksQueue();

        tq.add(t4, t1, t2, t3);

        assertEquals(t1, tq.get());
        assertEquals(t2, tq.get());
        assertEquals(t3, tq.get());
        assertEquals(t4, tq.get());

        tq.clear();

        tq.add(t4);
        tq.add(t1);
        tq.add(t2);
        tq.add(t3);

        assertEquals(t1, tq.get());
        assertEquals(t2, tq.get());
        assertEquals(t3, tq.get());
        assertEquals(t4, tq.get());
    }

    @Test
    public void showTest(){
    // Тест на показ элементов очереди без их удаления
        Task t1 = new Task("first","13:21:04",Priorities.High_Real);
        Task t4 = new Task("second","13:21:04",Priorities.Medium);

        TasksQueue tq = new TasksQueue(t4, t1);

        assertEquals(t1, tq.show());
        assertEquals(t1, tq.show());
    }

    @Test
    public void deleteFirstTaskTest(){
    //Тест метода, удаляющего из очереди первый элемент
        Task t1 = new Task("first","13:21:04",Priorities.High_Real);
        Task t4 = new Task("second","13:21:04",Priorities.Medium);

        TasksQueue tq = new TasksQueue(t4, t1);

        tq.deleteFirstTask();
        assertEquals(t4, tq.show());
    }
}

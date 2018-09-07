import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TasksQueue {
    private Queue<Task> queue;

    public TasksQueue(Task ...tasks){
        this.queue = new PriorityQueue<Task>(tasks.length);
        queue.addAll(Arrays.asList(tasks));
    }

    public boolean add(Task task){
    /* Добавляет элементы в очередь. Возвращает true - при успешном добавлении,
    false - в случае провала*/
        return queue.add(task);
    }

    public void add(Task ...tasks){
    // Добавляет несколько элементов в очередь
        queue.addAll(Arrays.asList(tasks));
    }

    public Task get(){
    //Возвращает первый элемент, с удалением из очереди. Если элемента нет - возвращает null
        return queue.poll();
    }

    public Task show(){
    // Возвращает первый элемент в очереди. Если элемента нет - возвращает null
        return queue.peek();
    }

    public boolean deleteFirstTask(){
    // Удаляет первое значение из очереди
        if(queue.poll() == null)
            return false;
        return true;
    }
}

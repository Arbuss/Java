import java.util.Objects;

public class Task implements Comparable<Task>{
    private Priorities priority;
    private String name;
    private String time;

    public Task(String name, String time, Priorities priority){
        this.name = name;
        this.time = time;
        this.priority = priority;
    }

    public Task(){
        this("default", "0:0:0", Priorities.Default);
    }

    public Task(Task source){
        this.name = source.getName();
        this.time = source.getTime();
        this.priority = source.getPriority();
    }

    public Priorities getPriority() {
        return priority;
    }

    public void setPriority(Priorities priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int compareTo(Task t) {
        if(this.priority.ordinal() > t.getPriority().ordinal())
            return 1;
        if(this.priority.ordinal() < t.getPriority().ordinal())
            return -1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (getPriority() != task.getPriority()) return false;
        if (!getName().equals(task.getName())) return false;
        return getTime().equals(task.getTime());
    }

    @Override
    public int hashCode() {
        int result = getPriority().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getTime().hashCode();
        return result;
    }
}

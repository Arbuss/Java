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
}

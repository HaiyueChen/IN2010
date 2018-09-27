import java.util.LinkedList;

class Task {
    public int id;
    public int time;
    public int staff;
    public String name;
    public int early;
    public int late;
    public LinkedList<Task> dependencies;
    public int cntPred;

    public Task(int id, int time, int staff, String name) {
        this.id = id;
        this.time = time;
        this.staff = staff;
        this.name = name;
    }

    public void add_dependency(Task dependent) {
        this.dependencies.add(dependent);
    }

}
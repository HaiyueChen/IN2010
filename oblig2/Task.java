import java.util.LinkedList;

class Task {
    public int id;
    public int time;
    public int staff;
    public String name;
    public int early;
    public int late;
    public LinkedList<Task> dependencies = new LinkedList<>();
    public int visit_status = 0;
    //public int cntPred;

    public Task(int id, String name, int time, int staff) {
        this.id = id;
        this.time = time;
        this.staff = staff;
        this.name = name;
    }

    public void add_dependency(Task dependent) {
        this.dependencies.add(dependent);
    }

    public LinkedList<Task> realizable(LinkedList<Task> current_path){
        if(this.visit_status == 1){
            current_path.add(this);
            return current_path;
        }
        else{
            current_path.add(this);
            this.visit_status = 1;
            LinkedList check = null;
            for(Task t : this.dependencies){
                check = t.realizable(current_path);
                if(check != null){
                    return check;
                }
            }
            this.visit_status = 2;
            return null;
        }
    }

}
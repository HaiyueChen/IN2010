import java.util.LinkedList;

import com.sun.javafx.runtime.SystemProperties;

class Task {
    public int id;
    public int time;
    public int staff;
    public String name;
    public int early_start = -1;
    public int early_finish = -1;
    public int late_start = -1;
    public int late_finish = -1;
    public int slack = -1;
    public Boolean critical = null;
    public LinkedList<Task> predecessors = new LinkedList<>();
    public LinkedList<Task> decendents = new LinkedList<>();
    public int visit_status = 0;
    public int cntPred = 0;

    public Task(int id, String name, int time, int staff) {
        this.id = id;
        this.time = time;
        this.staff = staff;
        this.name = name;
    }

    public void add_predecessor(Task predecessor) {
        this.predecessors.add(predecessor);
        this.cntPred ++;
    }

    public void add_decendent(Task decendent){
        this.decendents.add(decendent);
    }

    public LinkedList<Task> realizable(LinkedList<Task> current_path){
        //debug        
        // System.out.println("Now in " + this.id);
        // for(Task t : current_path){
        //     System.out.print(t.id + " ");
        // }
        // System.out.println("\n");

        if(this.visit_status == 1){
            return current_path;
        }
        else{
            current_path.add(this);
            this.visit_status = 1;
            LinkedList<Task> check = null;
            for(Task t : this.predecessors){
                check = t.realizable(current_path);
                if(check != null){
                    return check;
                }
            }
            this.visit_status = 2;
            //Because the nature of java objects, the task have to be removed from the 
            //path before returning to the last recursion level
            current_path.removeLast();
            return null;
        }
    }

    public void set_early(){
        if(this.predecessors.size() == 0){
            this.early_start = 0;
            this.early_finish = time;
            return;
        }
        else{
            int max_time = -1;
            for(Task pred : predecessors){
                if(pred.early_start == -1){
                    pred.set_early();
                }
                if(pred.early_finish > max_time){
                    max_time = pred.early_finish;
                }
            }
            this.early_start = max_time;
            this.early_finish = this.early_start + time;
            return;

        }
    }

    public void set_late(int min_finish_time){
        if(this.decendents.size() == 0){
             if(this.early_finish == min_finish_time){
                 this.late_start = this.early_start;
                 this.late_finish = this.early_finish;
                 this.slack = 0;
                 this.critical = true;
                 return;
             }
             else{
                if(this.id == 8){
                }
                this.slack = min_finish_time - this.early_finish;
                this.critical = false;
                this.late_start = this.early_start + this.slack;
                this.late_finish = this.early_finish + this.slack;
                return;
             }
        }
        else{
            for(Task decendent : this.decendents){
                if(decendent.slack == -1){
                    decendent.set_late(min_finish_time);
                }
            }
            int least_slack = -1;
            for(Task decendent : this.decendents){
                if(least_slack == -1){
                    least_slack = decendent.early_start - this.early_finish; 
                }
                int current_slack = decendent.early_start - this.early_finish; 
                if(current_slack < least_slack){
                    least_slack = current_slack;
                }
            }

            if(least_slack == 0){
                this.late_start = this.early_start;
                this.late_finish = this.early_finish;
                this.slack = 0;
                this.critical = true;
                return;
            }
            else{
                this.slack = least_slack;
                this.critical = false;
                this.late_start = this.early_start + this.slack;
                this.late_finish = this.early_finish + this.slack;
                return;
            }
        }
    }

}
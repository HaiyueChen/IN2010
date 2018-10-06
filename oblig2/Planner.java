import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.sun.javafx.runtime.SystemProperties;

class Planner {

    public HashMap<Integer, int[]> dependency_map = new HashMap<>();
    public HashMap<Integer, Task> tasks = new HashMap<>();
    public int min_finish_time = -1;


    public Planner(String filename) throws FileNotFoundException {

        Scanner s = new Scanner(new File(filename));
        int task_count = Integer.valueOf(s.nextLine());
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (!line.equals("")) {
                //Java did not split the line correctly with just space
                String[] info = line.split("\\s+");

                int task_id = Integer.valueOf(info[0]);
                String task_name = info[1];
                int task_time = Integer.valueOf(info[2]);
                int task_staff = Integer.valueOf(info[3]);
                
                int[] dependencies = null;
                
                if (info.length - 4 == 1) {
                    dependencies = new int[] {0};

                } 
                else {
                    dependencies = new int[info.length - 4];
                    for (int i = 4; i < info.length - 1; i++) {
                        dependencies[i - 4] = Integer.valueOf(info[i]);
                    }
                }

                this.dependency_map.put(task_id, dependencies);

                tasks.put(task_id, new Task(task_id, task_name, task_time, task_staff));
    
            }
        }
        for(Task itt : tasks.values()){
            int[] current_dependency =  dependency_map.get(itt.id);
            for(int id : current_dependency){
                if(id != 0){
                    Task predecessor = tasks.get(id);
                    itt.add_predecessor(predecessor);
                    predecessor.add_decendent(itt);

                }
            }
        }
        /*
        for(Task t : tasks.values()){
            System.out.println("ID: " + t.id + " name: " + t.name);
            for(Task d : t.dependencies){
                System.out.print(d.id + " ");
            }
            System.out.println(" \n");
        }
        */

    }

    public LinkedList<Task> detect_cycle(){
        //idealy one would not check the realizability of a plan several times,
        //therefore there is no need for a wipe procedure
        /*
        for(Task t : tasks.values()){
            t.visit_status = 0;
        }
        */
    
        LinkedList<Task> check = null;
        for(Task t : tasks.values()){
            if(t.visit_status == 0){
                check = t.realizable(new LinkedList<Task>());
                if(check != null){

                    return check;
                }
            }
        }
        return null;
    }

    public void realizable(){
        LinkedList<Task> cycle = this.detect_cycle();
        if (cycle != null) {
            
            while(cycle.getFirst() != cycle.getLast()){
                cycle.removeFirst();
            }
            
            System.out.println("Plan not realizable, cycle found:");
            for (Task t : cycle) {
                if(t == cycle.getLast()){
                    System.out.print("(" + t.id + ", " + t.name + ")");    
                }
                else{
                    System.out.print("(" + t.id + ", " + t.name + ")" + " ==> ");

                }
            }
            System.exit(0);
        }
    }


    public void set_early(){
        for(Task t : tasks.values()){
            if(t.early_start == -1){
                t.set_early();
            }
            if(t.early_finish > this.min_finish_time){
                this.min_finish_time = t.early_finish;
            }
        }
    }

    public void set_late(){
        if(this.min_finish_time == -1){
            this.set_early();
        }

        for(Task t : tasks.values()){
            if(t.slack == -1){
                t.set_late(this.min_finish_time);
            }
        }
    }

    public void print_info(){
        System.out.println("-----------------------------------------");
        System.out.println("**** Task overview ****");
        for(Task t : tasks.values()){
            System.out.println("\nTask id: " + t.id + " |  Task name: " + t.name);
            System.out.println("Time requirement: " + t.time);
            System.out.println("Manpower requirement: " + t.staff);
            System.out.print("Early start: " + t.early_start);
            System.out.println("    |    Early finish: " + t.early_finish);
            System.out.print("Late start: " + t.late_start);
            System.out.println("     |    Late finish: " + t.late_finish);
            System.out.println("Slack: " + t.slack);
            System.out.println("Task dependency: ");
            if(t.decendents.size() == 0){
                System.out.println("   None");
            }else{
                System.out.print("   ");
                for(Task j : t.decendents){
                    System.out.print(j.id + " ");
                }
                System.out.println("\n");
            }
        }

        System.out.println("\n\nMinimum project finish time is: " + this.min_finish_time);
        System.out.println("\n-----------------------------------------");
    }

    public void simulate(){
        if(this.min_finish_time == -1){
            this.set_late();
        }

        LinkedList<Task> remaining_tasks = new LinkedList<>();
        LinkedList<Task> current_running = new LinkedList<>();
        remaining_tasks.addAll(this.tasks.values());

        int curernt_staff = 0;
        Boolean check_print = false;

    
        System.out.println("\n**** Simulation start ****\n");
        for(int time = 0; time < this.min_finish_time + 1; time++){
            LinkedList<Task> done = new LinkedList<>();
            LinkedList<Task> started = new LinkedList<>();
            Iterator<Task> itt_c = current_running.iterator();
            while(itt_c.hasNext()){
                Task d = itt_c.next();
                if(d.late_finish == time){
                    check_print = true;
                    done.add(d);
                    for(Task children : d.decendents){
                        children.cntPred --;
                    }
                    curernt_staff -= d.staff;
                    itt_c.remove();
                }
            }
            
            Iterator<Task> itt_r = remaining_tasks.iterator();
            while (itt_r.hasNext()) {
                Task t = itt_r.next();
                if (t.cntPred == 0 && time == t.late_start) {
                    check_print = true;
                    current_running.add(t);
                    started.add(t);
                    curernt_staff += t.staff;
                    itt_r.remove();
                }
            }

            if(check_print){
                System.out.println("\nTime: " + time);
                for(Task t : done){
                    System.out.println("Finished: " + t.id);
                }
                for(Task t : started){
                    System.out.println("Starting: " + t.id);
                }

                System.out.println("Current staff: " + curernt_staff + "\n");
                check_print = false;
            }
        }

        System.out.println("**** Shortest possible time for project is " + this.min_finish_time + " ****\n");
    }

    public void simulate_heap(){
        TaskHeap heap = new TaskHeap();
        
        for (Task t : tasks.values()) {
            heap.add(t);
        }

        TaskNode current = heap.pop_first();
        int current_time = current.value.late_start;
        int staff = current.value.staff;
        System.out.println("-----------------------------------------");
        System.out.println("**** Task overview ****");

        System.out.println("\nTime: " + current_time);
        System.out.println("Starting: " + current.value.id);
        heap.add_finish(current);
        int count = 0;
        while (!heap.is_empty()) {
            current = heap.pop_first();
            if (current.value.late_start == current_time && !current.started) {
                // System.out.println("Starting: " + current.value.id + " key: " + current.key);
                System.out.println("Starting: " + current.value.id);
                staff += current.value.staff;
                heap.add_finish(current);
            } else if (current.value.late_finish == current_time && current.started) {
                // System.out.println("Finished: " + current.value.id + " key: " + current.key);
                System.out.println("Finished: " + current.value.id);
                staff -= current.value.staff;
            } else {
                System.out.println("Current staff: " + staff);
                if (current_time < current.value.late_start && !current.started) {
                    current_time = current.value.late_start;
                    staff += current.value.staff;
                    System.out.println("\nTime: " + current_time);
                    // System.out.println("Starting: " + current.value.id + " key: " + current.key);
                    System.out.println("Starting: " + current.value.id);
                    heap.add_finish(current);
                } else if (current_time < current.value.late_finish && current.started) {
                    current_time = current.value.late_finish;
                    staff -= current.value.staff;
                    System.out.println("\nTime: " + current_time);
                    // System.out.println("Finished: " + current.value.id + " key: " + current.key);
                    System.out.println("Finished: " + current.value.id);

                }

            }
        }
        System.out.println("Current staff: " + staff);
        System.out.println("**** Shortest possible time for project is " + current_time + " ****\n");
    }



    public void wipe_all_tasks(){
        this.min_finish_time = -1;
        for(Task t : tasks.values()){
            t.early_start = -1;
            t.early_finish = -1;
            t.late_start = -1;
            t.late_finish = -1;
            t.slack = -1;
            t.critical = null;
            t.visit_status = -1;
        }
    }


}
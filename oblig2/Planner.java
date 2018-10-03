import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import com.sun.javafx.runtime.SystemProperties;

class Planner {

    public HashMap<Integer, int[]> dependency_map = new HashMap<>();
    public HashMap<Integer, Task> tasks = new HashMap<>();

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
                    Task dependent = tasks.get(id);
                    itt.add_dependency(tasks.get(id));

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

    public LinkedList<Task> realizable(){
        //idealy one would not check the realizability of a plan several times,
        //therefore there is no need for a wipe procedure
        /*
        for(Task t : tasks.values()){
            t.visit_status = 0;
        }
        */
    
        LinkedList check = null;
        for(Task t : tasks.values()){
            if(t.visit_status == 0){
                check = t.realizable(new LinkedList<>());
                if(check != null){
                    return check;
                }
            }
        }
        return null;
    }

}
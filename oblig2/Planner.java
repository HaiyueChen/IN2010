import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import com.sun.javafx.runtime.SystemProperties;

class Planner {

    public HashMap<Integer, int[]> dependency_map;
    public LinkedList<Task> tasks;

    public Planner(String filename) throws FileNotFoundException {

        Scanner s = new Scanner(new File(filename));
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (!line.equals("")) {
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
                System.out.println("Task id: " + task_id);
                System.out.println("Task name: " + task_name);
                System.out.println("Task time: " + task_time);
                System.out.println("Task staff: " + task_staff);
                System.out.print("Dependencies: ");
                for(int i : dependencies){
                    System.out.print(i + " ");
                }
            }
        }

    }

}
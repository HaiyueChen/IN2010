import java.io.FileNotFoundException;
import java.util.LinkedList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.sun.javafx.runtime.SystemProperties;

class Main{

    public static void main(String[] args) {
        Planner p = null;

        if(args.length != 1){
            System.out.println("Please provide the file name and only the file name as the cmd argument");
            System.exit(0);
        }
        String filename = args[0];
        try {
            p = new Planner(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(0);
        }

        
        //check if project realizable, if not print cycle and terminate
        p.realizable();

        //print simulation of program after executing set_early and set_late
        p.simulate();

        //print info about tasks after simulation is done
        p.print_info();

        //print simulation with heap implementation
        //p.simulate_heap();





    }

    


}
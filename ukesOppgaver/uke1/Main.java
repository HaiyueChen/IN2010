import java.io.PrintWriter;
import java.util.Random;
import java.io.File;

class Main{

    public static void main(String[] args) {
        int sum = 0;

        PrintWriter print = null; 

        try {
            print = new PrintWriter("in.txt");
            
        } catch (Exception e) {
            //TODO: handle exception
        }

        Random rand = new Random();
        int temp = 0;
        for(int i = 0; i < 100; i++){
            //temp = rand.nextInt();
            //print.println(temp);
            //sum += temp;
            print.println(i);

        }

        print.close();
        Tre t = new Tre();
        try {
            t.read(new File("in.txt"));
            
        } catch (Exception e) {
            //TODO: handle exception
        }

        //System.out.println(t.sum_nodes());
        //System.out.println(sum);

        t.set_d_h();
        System.out.println(t.root.depth);
        System.out.println(t.root.height);


    }




}
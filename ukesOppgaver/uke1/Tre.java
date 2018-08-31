import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

class Tre{
    public Node root = null;

    public void read(File f) throws FileNotFoundException{
        Scanner s = new Scanner(f);
        while(s.hasNext()){
            this.add(Integer.valueOf(s.nextLine()));

        }

    }


    public void add(int i){
        if(root == null){
            Node temp = new Node(i);
            root = temp;    
        }
        else{
            root.add(i);

        }

    }

    public void set_d_h(){
        root.set_d_h(0);

    }

    public Node search(int i){
        if(root == null){
            return null;

        }
        else{
            return root.search(i);

        }

    }

    public int sum_nodes(){
        return root.sum_nodes();

    }





}
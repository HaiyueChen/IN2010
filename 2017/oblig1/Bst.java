import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

class Bst{
    public BstNode root = null;

    public Bst readFile(File f) throws FileNotFoundException{
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            this.addNode(s.nextLine());
        }
        s.close();
        
        return this;
    }

    public void addNode(String s){
        if(this.root == null){
            this.root = new BstNode(s);
        }
        else{
            this.root.addNode(s);
        }
    }

    public void printTree(){
        if(this.root != null){
            this.root.printNode("");
        }
    }

}
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

class Bst{
    public BstNode root = null;

    public Bst readFile(String fileName) throws FileNotFoundException{
        Scanner s = new Scanner(new File(fileName));
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
/*
    public void printTree(){
        if(this.root != null){
            this.root.printNode("");
        }
    }
*/

    public BstNode search(String s){
        return this.root.search(s);
    }

    public BstNode searchItt(String s){
        BstNode current = root;
        while (current != null){
            if(s.equals(current.data)){
                return current;
            }
            else if(s.compareTo(current.data) < 0){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        return current;

    }

    public BstNode insert(String s){
        return this.root.insert(s);
    }

    public BstNode delete(String s){
        if(s.equals(root.data) && root.)
        BstNode to_be_deleted = this.search(s);

        if(to_be_deleted != null){
            to_be_deleted.delete();
        }

        return to_be_deleted;
    }


}
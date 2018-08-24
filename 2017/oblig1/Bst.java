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
        BstNode to_be_deleted = null;
        if(s.equals(root.data)){
            if(root.numb_children() == 0){
                to_be_deleted = this.root;
                this.root = null;
                return to_be_deleted;
            }
            else if(root.numb_children() == 1){
                
                to_be_deleted = root;

                if(root.left != null){    
                    root = root.left;
                    root.parent = null;
                }
                else{
                    root = root.right;
                    root.parent = null;

                }
                return to_be_deleted;

            }
            else{
                to_be_deleted = root.left.right_itter();
                String data_swap = to_be_deleted.data;
                to_be_deleted.data = root.data;
                root.data = data_swap;
                to_be_deleted.parent.right = null;
                to_be_deleted.parent = null;
                return to_be_deleted;


            }

        }
        else{
            to_be_deleted = this.search(s);
            return to_be_deleted.delete();

        }

    }


}
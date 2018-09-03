import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class BSTree {
    private Node root = null;
    private int size = 0;
    private int arrayIndex = 0;
    private int[] sorted;


    public void read(File f) throws FileNotFoundException{
        Scanner s = new Scanner(f);
        int value = 0;
        while(s.hasNextLine()){
            value = Integer.valueOf(s.nextLine());
            this.add(value);

        }
    }

    public int size(){
        return size;
    }


    public void add(int v){
        if(size == 0){
            Node temp = new Node(v);    
            this.root = temp;
        }
        else{
            root.add(v);
        }
        size++;

    }

    public boolean exitstInTree(int value){
        return find(value) != null;

    }

    //Work in progress
    public boolean remove(int v){
        return true;
    }

    //Work in progress
    public int findNearestSmallerThan(int value){
        return 0;
    }

    public void addAll(int[] integers){
        for(int i = 0; i < integers.length; i++){
            this.add(integers[i]);
        }
    }

    //Work in progress
    public int[] sortedArray(){
        if(root == null){
            return null;
        }
        else{
            arrayIndex= 0;
            sorted = new int[size];
            root.sortedArray();;
            return sorted;
        }
    }

    //work in progress
    public int[] findInRange(int low, int high){
        return new int[size];

    }

    private Node find(int value){
        return root.find(value);
    }

    private Node findParent(Node n){
        return n.parent;
    }

    private Node findGrandparent(Node n){
        return n.parent.parent;

    }




    private class Node {
        public Node left, right, parent;
        public int value;

        public Node() {
            value = 0;
        }

        public Node(int v) {
            value = v;
        }

        public void add(int v){
            if(v < this.value){
                if(this.left == null){
                    Node temp = new Node(v);
                    this.left = temp;
                    temp.parent = this;
                }
                else{
                    this.left.add(v);
                }
            }
            else{
                if(this.right == null){
                    Node temp = new Node(v);
                    this.right = temp;
                    temp.parent = this;
                }
                else{
                    this.right.add(v);
                }
            }
        }

    //self-defined helper function for sortedArray()
        public void sortedArray(){
            if(left != null){
                left.sortedArray();
            }
            sorted[arrayIndex] = this.value;
            arrayIndex ++;

            if(right != null){
                right.sortedArray();

            }

        }


        public Node find(int v){
            if(v == value){
                return this;

            }
            else if(v < value && this.left != null){
                return this.left.find(v);
            }
            else if(v > value && this.right != null){
                return this.right.find(v);
            }
            else{
                return null;
            }



        }
        



    }

}
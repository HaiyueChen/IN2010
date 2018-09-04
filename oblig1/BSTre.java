import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BSTree<T extends Comparable <T>> {
    private Node root = null;
    private int size = 0;
    private ArrayList<T> sorted = new ArrayList<>();
    private ArrayList<T> inRange = new ArrayList<>();



    public void read(File f) throws FileNotFoundException{
        Scanner s = new Scanner(f);
        T value;
        while(s.hasNextLine()){
            value = (T) s.nextLine();
            this.add(value);
        }
    }

    public int size(){
        return size;
    }


    public void add(T v){
        if(size == 0){
            Node temp = new Node(v);    
            this.root = temp;
        }
        else{
            root.add(v);
        }
        size++;

    }

    public boolean exitstInTree(T value){
        return find(value) != null;

    }


    public boolean remove(T v){
        if(root != null){
            if (root.value.compareTo(v) == 0) {
                if (root.left == null && root.right == null) {
                    root = null;

                }
                else if(root.left != null && root.right == null){
                    root = root.left;

                }
                else if(root.left == null && root.right != null){
                    root = root.right;

                }
                else{
                    Node current = root.left;
                    while(current.right != null){
                        current = current.right;
                    }
                    T data_to_swap = current.value;
                    root.value = data_to_swap;
                    current.parent.right = null;

                }
            size --;
            return true;

            } else {
                return root.remove(v);
            }
        }
        else{
            return false;
        }
        
    }

    
    public T findNearestSmallerThan(T value){
        if(root != null){
            Node current = root;
            boolean found_smaller = false;

            while(!found_smaller && current.left != null){
                if(value.compareTo(curernt.value) < 0 && current.left != null){
                    current = current.left;
                }
                else{
                    found_smaller = true;
                }
            }

            int diff = value.compareTo(current.value);
            if(diff < 0){
                return null;
            }
            else if(diff == 0 && current.right == null){
                return null;
            }
            else{
                boolean found_smallest = false;
                while (!found_smallest) {
                    if (current.right != null) {
                        if(value.compareTo(current.right.value) > diff && value.compareTo(current.right.value) < 0){
                            current = current.right;
                            diff = value.compareTo(current.value);
                        }

                    } else {
                        found_smallest = true;
                    }
                }
                return current.value;
            }




        }
        else{
            return null;
        }
    }

    public void addAll(ArrayList<T> values){
        for(T temp : values){
            this.add(temp);
        }
    }

    
    public ArrayList<T> sortedArrayList(){
        sorted = new ArrayList<>();
        if(root != null){
            root.sortedArrayList();
        }
        return sorted;
    }

    //work in progress
    public ArrayList<T> findInRange(int low, int high){
        inRange = new ArrayList<>();
        if(root != null){
            root.findInRange(low, high);
        }
        return inRange;
    }

    private Node find(T value){
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
        public T value;

        public Node() {
            value = 0;
        }

        public Node(T v) {
            value = v;
        }

        public void add(T v){
            if(v.compareTo(this.value) < 0){
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

        public boolean remove(T v){
            Node to_remove = this.find(v);
            if(to_remove != null){
                Node parent = to_remove.parent;
                int orintation = to_remove.value.compareTo(parent.value);
                if(to_remove.left == null && to_remove.right == null){
                    if(orintation < 0){
                        parent.left = null;
                    }
                    else{
                        parent.right = null;
                    }
                }
                else if(to_remove.left != null && to_remove.right == null){
                    if(orientation < 0){
                        parent.left = to_remove.left;

                    }
                    else{
                        parent.right = to_remove.left;
                        
                    }
                }
                else if (to_remove.left == null && to_remove.right != null) {
                    if (orientation < 0) {
                        parent.left = to_remove.right;

                    } else {
                        parent.right = to_remove.right;

                    }
                }
                else{
                    Node current = this.left;
                    while(current.right != null){
                        current = current.right;
                    }
                    parent = current.parent;
                    T data_to_swap = current.value;
                    this.value = data_to_swap;
                    if(data_to_swap.compareTo(parent.value) < 0){
                        parent.left = null;
                    }
                    else{
                        parent.right = null;
                    }

                }
            
                size --;
                return true;
            }
            else{
                return false;

            }

        }


        //self-defined helper function for sortedArrayList()
        public void sortedArrayList(){
            if(left != null){
                left.sortedArrayList();
            }
            sorted.add(this.value);

            if(right != null){
                right.sortedArrayList();
            }
        }

        //self-defined helper function for findInRange()
        public void findInRange(T low, T high){
            if(value.compareTo(low) >= 0 && value.compareTo(high) <=0){
                inRange.add(value);

            }
            if(left != null && left.value.compareTo(low) >= 0){
                left.findInRange(low, high);
            }
            if(right != null && right.value.compareTo(high) <= 0){
                right.findInRange(low, high);
            }



        }
        


        public Node find(T v){
            if(v == value){
                return this;

            }
            else if(v.compareTo(value) < 0 && this.left != null){
                return this.left.find(v);
            }
            else if(v.compareTo(value) > 0 && this.right != null){
                return this.right.find(v);
            }
            else{
                return null;
            }   
        }
    }

}
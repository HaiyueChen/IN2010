import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BSTree <T extends Comparable <T>> implements BSTOper<T> {
    protected Node root = null;
    protected int size = 0;
    protected ArrayList<T> sorted = new ArrayList<>();
    protected ArrayList<T> inRange = new ArrayList<>();



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

    public boolean existsInTree(T value){
        T value2 = value;
        return find(value2) != null;

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
            return root.findSmaller(value, -1, root);
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

    
    public ArrayList<T> findInRange(T low, T high){
        inRange = new ArrayList<>();
        if(root != null){
            root.findInRange(low, high);
        }
        return inRange;
    }

    protected Node find(T value){
        return root.find(value);
    }

    protected Node findParent(Node n){
        return n.parent;
    }

    protected Node findGrandparent(Node n){
        if(n.parent != null){
            return n.parent.parent;

        }
        else{
            return null;
        }

    }


    protected class Node {
        public Node left, right, parent;
        public T value;

        public Node() {
            value = null;
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
                int orientation = to_remove.value.compareTo(parent.value);
                if(to_remove.left == null && to_remove.right == null){
                    if(orientation < 0){
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
        //Slv definert metode for findNearestSmallerThan()
        public T findSmaller(T q_value, int min_diff, Node smallest){
            if(min_diff == -1){
                min_diff = q_value.compareTo(this.value);
            }

            if(q_value.compareTo(this.value) > 0){
                if(q_value.compareTo(this.value) < min_diff){
                    min_diff = q_value.compareTo(this.value);
                    smallest = this;
                }
            }
            if(q_value.compareTo(this.value) < 0 ){
                if(this.left != null){
                    return this.left.findSmaller(q_value, min_diff, smallest);
                }
                else{
                    return smallest.value;

                }
            }
            else{
                if(this.right != null){
                    return this.right.findSmaller(q_value, min_diff, smallest);
                }
                else{
                    return smallest.value;
                }

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

        public void right_rotate() {
            if (this.left != null) {
                Node newRoot = this.left;
                if (this.parent != null) {
                    if (this.value.compareTo(this.parent.value) < 0) {
                        this.parent.left = newRoot;
                    } else {
                        this.parent.right = newRoot;
                    }
                }
                newRoot.parent = this.parent;
                this.parent = newRoot;
                this.left = newRoot.right;
                newRoot.right = this;
                if (this.left != null) {
                    this.left.parent = this;

                }
            }
        }

        public void left_rotate() {
            if (this.right != null) {
                Node newRoot = this.right;
                if (this.parent != null) {
                    if (this.value.compareTo(this.parent.value) < 0) {
                        this.parent.left = newRoot;
                    } else {
                        this.parent.right = newRoot;

                    }

                }
                newRoot.parent = this.parent;
                this.parent = newRoot;
                this.right = newRoot.left;
                newRoot.left = this;
                if (this.right != null) {
                    this.right.parent = this;
                }

            }

        }
    }

}
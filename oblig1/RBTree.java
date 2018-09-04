public class RBTree<sT extends Comparable<T>> extends BSTree{
    private static byte BLACK = 1;
    private static byte RED =2;

    public RBTree(){
        super();
    }


    @Override
    public void add(T v){
        if(root == null){
            RBNode temp = new RBNode(v);
            temp.setToBlack();
            root = temp;
            size ++;

        }
        else{
            root.add(v);

        }
    }


    private class RBNode extends Node{
        private static byte BLACK = 1;
        private static byte RED = 2;
        
        private byte colour = 0;


        public RBNode(T v){
            super(v);

        }

        public void right_rotate(){
            if(this.left != null){
                RBNode newRoot = this.left;
                if(this.parent != null){
                    if(this.value.compareTo(this.parent.value) < 0){
                        this.parent.left = newRoot;
                    }
                    else{
                        this.parent.right = newRoot;
                    }
                }
                newRoot.parent = this.parent;
                this.parent = newRoot;
                this.left = newRoot.right;
                newRoot.right = this;
                if(this.left != null){
                    this.left.parent = this;

                }
            }
        }

        public void left_rotate(){
            if(this.right != null){
                RBNode newRoot = this.right;
                if(this.parent != null){
                    if(this.value.compareTo(this.parent.value) < 0){
                        this.parent.left = newRoot;
                    }
                    else{
                        this.parent.right = newRoot;

                    }

                }
                newRoot.parent = this.parent;
                this.parent = newRoot;
                this.right = newRoot.left;
                newRoot.left = this;
                if(this.right != null){
                    this.right.parent = this;
                }

            }


        }

        public boolean isRed(){
            return colour == RED;
        }

        public boolean isBlack(){
            return colour == BLACK;
        }

        public void setToRed(){
            colour = RED;
        }

        public void setToBlack(){
            colour = BLACK;
        }


    }
    
    
}


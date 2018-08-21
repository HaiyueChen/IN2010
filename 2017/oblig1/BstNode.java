class BstNode{

    public BstNode parent, left, right;
    public String data;

    public BstNode(String s){
        this.data = s;
    }

    public void addNode(String s){
        
        if(s.compareTo(this.data) < 0){
            if(this.left == null){
                this.left = new BstNode(s);
                this.left.parent = this;
            
            }
            else{
                this.left.addNode(s);
            }

        }
        else{

            if(this.right == null){
                this.right = new BstNode(s);
                this.right.parent = this;

            }
            else{
                this.right.addNode(s);

            }

        }
    }

    public BstNode search(String s){
        if(s.equals(this.data)){
            return this;
        }
        else if(this.left != null && s.compareTo(this.data) < 0){
            //System.out.println("left");
            return left.search(s); 
        }
        else if(this.right != null && s.compareTo(this.data) > 0){
            //System.out.println("right");
            return right.search(s);
        }
        return null;
    }

    public int numb_children(BstNode node){
        int num = 0;
        if(node.left != null){
            num ++;
        }

        if(node.right != null){
            num ++;
        }
        return num;

    }

    public void delete(){
        if(this.left == null && this.right == null){
            if(this.parrent)
        
        }
        else if(this.left != null ^ this.right != null){
            if(this.left != null){
                this.parent
            }
        }

    }

    public String find_branch(BstNode node){
        if(this.left == node){
            return "left";
        }
        else if(this.right == node){
            return "right";
        }
        else{
            return "error";
        }
    }


    public BstNode insert(String s){
        if(s.compareTo(this.data) < 0){
            if(this.left == null){
                this.left = new BstNode(s);
                return this.left;
            }
            else{
                return this.left.insert(s);
            }
        }
        else{
            if(this.right == null){
                this.right = new BstNode(s);
                return this.right;
            }
            else{
                return this.right.insert(s);
            }
        }
    }


    /*
    public void printNode(String padding){
        System.out.print(padding + this.data + padding);
        
        String newPadding =  padding + "     ";
        if(this.left != null){
            this.left.printNode(newPadding);
        }
        
        if(this.right != null){
            this.right.printNode(newPadding);
        }

        System.out.println();

    }
*/


}
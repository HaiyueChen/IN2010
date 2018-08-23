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

    public int numb_children(){
        int num = 0;
        if(this.left != null){
            num ++;
        }

        if(this.right != null){
            num ++;
        }
        return num;

    }

    public BstNode left_itter(){
        if(this.left == null){
            return this;
        }
        else{
            return this.left.left_itter();
        }
    }

    public BstNode right_itter(){
        if(this.right == null){
            return this;
        }
        else{
            return this.right.right_itter();
        }
    }

    public BstNode delete(){
        int orientation = this.data.compareTo(this.parent.data);

        if(this.numb_children() < 1){
            
            if(orientation < 0){
                this.parent.left = null;
            }
            else{
                this.parent.right = null;
            }
            return this;
        
        }
        else if(this.left != null ^ this.right != null){
            if(this.left != null){
                
                if (orientation < 0) {
                    this.parent.left = this.left;
                }
                else{
                    this.parent.right = this.left;
                }
                
                this.left.parent = null;

            }
            else{
                if(orientation < 0){
                    this.parent.left = this.right;

                }
                else{
                    this.parent.right = this.right;

                }
                
                this.right.parent = null;
            }
            return this;
       
        }
        else{
            if(orientation < 0){
                BstNode replacement = this.right_itter();
                String data_swap = replacement.data;
                
                replacement.data = this.data;
                this.data = data_swap;
                
                replacement.parent.right = null;
                replacement.parent = null;
                return replacement;

            }
            else{
                BstNode replacement = this.left_itter();
                String data_swap = replacement.data;

                replacement.data = this.data;
                this.data = data_swap;

                replacement.parent.left = null;
                replacement.parent = null;
                return replacement;

            }
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
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
            
            }
            else{
                this.left.addNode(s);
            }

        }
        else{

            if(this.right == null){
                this.right = new BstNode(s);

            }
            else{
                this.right.addNode(s);

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
class Node{

    public int data, depth, height;
    public Node left, right, parent;

    public Node(int i){
        data = i;

    }

    public void add(int i){
        if(i < data){
            if(left == null){
                Node temp = new Node(i);
                left = temp;
            }
            else{
                left.add(i);

            }

        }
        else{
            if(right == null){
                Node temp = new Node(i);
                right = temp;

            }
            else{
                right.add(i);

            }

        }

    }

    public Node search(int i){
        if(data == i){
            return this;

        }
        else if(i < data && left != null){
            return left.search(i);

        }
        else if(i > data && right != null){
            return right.search(i);

        }
        else{
            return null;

        }

    }

    public void set_d_h(int d){
        depth = d;
        int left_h = 0;
        int right_h = 0;


        if (left == null && right == null) {
            height = 0;
            return;
        }

        if(left != null){
            left.set_d_h(d + 1);
            left_h = left.height;
        }

        if(right != null){
            right.set_d_h(d + 1);
            right_h = right.height;
        }

        int max_height = Math.max(left_h, right_h);
        height = max_height + 1;


        



    }



    public int sum_nodes(){
        int sum = data;

        if(left != null){
            sum += left.sum_nodes();
        }
        if(right != null){
            sum += right.sum_nodes();

        }
        return sum;



    }



}
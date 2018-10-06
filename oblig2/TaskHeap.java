import java.util.LinkedList;

class TaskHeap{
    public int size = 0;
    public TaskNode[] tasks = new TaskNode[20];

    public void add(Task t){
        size ++;
        if(size > tasks.length - 1){
            int new_array_size = tasks.length * 2;
            TaskNode[] new_tasks = new TaskNode[new_array_size];
            for(int i = 1; i < tasks.length ; i++){
                new_tasks[i] = tasks[i];
            }
            tasks = new_tasks;
        }
        TaskNode current = new TaskNode(t); 
        tasks[size] = current;
        int current_index = size;
        
        if(current_index != 1){
            int parent_index = current_index / 2;
            TaskNode parent = tasks[parent_index];
            while(current_index != 1 && parent.key > current.key ){
                tasks[parent_index] = current;
                tasks[current_index] = parent;

                current_index = parent_index;
                parent_index = current_index / 2;
                parent = tasks[parent_index];
            }
        }
    }

    public void add_finish(TaskNode node){
        size ++;
        node.set_to_finish();
        tasks[size] = node;
        int current_index = size;
        if(!(current_index == 1)){
            int parent_index = current_index / 2;
            TaskNode parent = tasks[parent_index];
            while (current_index != 1 && parent.key > node.key) {
                tasks[parent_index] = node;
                tasks[current_index] = parent;

                current_index = parent_index;
                parent_index = current_index / 2;
                parent = tasks[parent_index];
            }
        }

    }

    //pop_first modified specificly for this assignment
    public TaskNode pop_first(){
        if(size == 0){
            return null;
        }
        else if(size == 1){
            TaskNode to_remove = tasks[1];
            tasks[1] = null;
            size --;
            return to_remove;
        }
        else{
            TaskNode to_remove = tasks[1];
            TaskNode last = tasks[size];
            tasks[1] = last;
            tasks[size] = null;
            size --;

            int current_index = 1;
            //heap bubble down
            while(true){
                TaskNode left = null;
                TaskNode right = null;
                int left_index = current_index * 2;
                int right_index = current_index * 2 + 1;


                if(left_index <= size){
                    left = tasks[left_index];
                }
                if(right_index <= size){
                    right = tasks[right_index];
                }

                //if there are no children
                if(left == null && right == null){
                    break;
                }
                //if left children but no right
                else if(left != null && right == null){
                    if(last.key > left.key){
                        tasks[left_index] = last;
                        tasks[current_index] = left;
                        current_index = left_index;
                    }
                    else{
                        break;
                    }
                }
                //if right children but no left
                else if(right != null && left == null){
                    if(last.key > right.key){
                        tasks[right_index] = last;
                        tasks[current_index] = right;
                        current_index = right_index;
                    }
                    else{
                        break;
                    }
                }
                //if both children
                //if current smaller/equal both left and right
                else if(last.key <= left.key && last.key <= right.key){
                    break;
                }
                else{
                    TaskNode smallest = null;
                    int smallest_index = -1;
                    if(left.key < right.key){
                        smallest = left;
                        smallest_index = left_index;
                    }
                    else{
                        smallest  = right;
                        smallest_index = right_index;
                    }
 
                    tasks[smallest_index] = last;
                    tasks[current_index] = smallest;
                    current_index = smallest_index;
                }
                    
            }

            return to_remove;
        }
    }



    public Task get_index(int index){
        if(index > size){
            return null;
        }
        else if(size < 1){
            return null;
        }
        else{
            return tasks[index].value;
        }

    }   

    public Task get_first(){
        return tasks[1].value;
    }

    public Task get_last(){
        return tasks[tasks.length - 1].value;
    }

    public Boolean is_empty(){
        return size == 0;
    }

    public int size(){
        return size;
    }


}
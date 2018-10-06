class TaskNode{
    public int key;
    public Boolean started = false;
    public Task value;

    public TaskNode(Task t){
        this.key = t.late_start;
        this.value= t;

    }

    public void set_to_finish(){
        this.started = true;
        this.key = value.late_finish;
    }




}
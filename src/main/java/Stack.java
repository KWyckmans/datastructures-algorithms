public class Stack {
    public Stack(){
        list = new LinkedList();
    }

    public int pop(){
        return list.popFront();
    }

    public void push(int item){
        list.insert(item);
    }

    private LinkedList list;
}

package be.wyckd.datastructures;

public class Queue {
    public Queue() {
    }

    public void enqueue(int item) {
        list.insert(item);
    }

    public int dequeue() {
        return list.popBack();
    }

    private LinkedList list = new LinkedList();
}

package be.wyckd.datastructures;

public class Queue<T extends Comparable<T>> {
    public Queue() {
    }

    public void enqueue(T item) {
        list.insert(item);
    }

    public T dequeue() {
        return list.popBack();
    }

    private LinkedList<T> list = new LinkedList<>();
}

package be.wyckd.datastructures;

public class Stack<T extends Comparable<T>> {
    public Stack() {
        list = new LinkedList<>();
    }

    public T pop() {
        return list.popFront();
    }

    public void push(T item) {
        list.insert(item);
    }

    private LinkedList<T> list;
}

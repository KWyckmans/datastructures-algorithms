package be.wyckd.datastructures;

import java.util.Optional;

public class LinkedList {
    private Node head;

    public LinkedList() {

    }

    public void insert(int value) {
        Node node = new Node(value, head);
        head = node;
    }

    public int count() {
        int size = 0;

        if (this.head == null) {
            return 0;
        } else {
            Node current = this.head;

            while (current.next != null) {
                size += 1;
                current = current.next;
            }

            return size + 1;
        }
    }

    public boolean empty() {
        return count() == 0;
    }

    public Optional<Integer> search(int item) {

        Node current;
        for (current = this.head; current.next != null; current = current.next) {
            if (current.value == item) {
                return Optional.of(current.value);
            }
        }

        if (current.value == item) {
            return Optional.of(current.value);
        } else {
            return Optional.empty();
        }
    }

    public void delete(int item) {
        Node current = this.head;

        if (current.value == item) {
            this.head = current.next;
        } else {
            while (current.next != null) {
                if (current.next.value == item) {
                    current.next = current.next.next;
                    break;
                }

                current = current.next;
            }
        }
    }

    public int popFront() {
        Node top = this.head;
        this.head = this.head.next;

        return top.value;
    }

    public int popBack() {
        Node current = this.head;

        if (current.next == null) {
            this.head = null;
            return current.value;
        }

        while (current.next.next != null) {
            current = current.next;
        }

        Node last = current.next;
        current.next = null;
        return last.value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        if (this.head != null) {
            print(this.head, builder);
        }

        builder.append("]");
        return builder.toString();
    }

    public LinkedList sort() {
        if (this.head == null || this.head.next == null) {
            return this;
        } else {
            LinkedList newList = new LinkedList();
            newList.head = this.head;
            Node listTraverser = this.head.next;
            Node newListNodeTraverser = new Node(newList.head.value, null);

            while (listTraverser != null) {
                Node previous = null;
                Node item = new Node(listTraverser.value, null);

                while (newListNodeTraverser != null && newListNodeTraverser.value < listTraverser.value) {
                    previous = newListNodeTraverser;
                    newListNodeTraverser = newListNodeTraverser.next;
                }

                if (previous == null) {
                    newList.head = item;
                    item.next = newListNodeTraverser;
                } else {
                    previous.next = item;
                    item.next = newListNodeTraverser;
                }

                newListNodeTraverser = newList.head;
                listTraverser = listTraverser.next;
            }

            return newList;
        }
    }

    private void print(Node node, StringBuilder builder) {
        builder.append(node);
        if (node.next != null) {
            print(node.next, builder);
        }
    }

    private class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder repr = new StringBuilder();
            repr.append(this.value);

            if (next != null) {
                repr.append(", ");
            }

            return repr.toString();
        }
    }
}

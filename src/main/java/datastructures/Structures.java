package datastructures;

import java.util.function.Consumer;

public class Structures {
    public static void sort(LinkedList list,  Consumer<LinkedList> algorithm){
        algorithm.accept(list);
    }

    public static class Algorithms {
        public static void insertionSort(LinkedList list) {
        }
    }
}

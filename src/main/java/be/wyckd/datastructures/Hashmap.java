package be.wyckd.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class Hashmap<K, V> {
    private static final double RESIZE_LIMIT = 0.75;
    private int buckets = 1;
    private int entries = 0;

    private ArrayList<List<Element>> contents = new ArrayList<>(buckets);

    public Hashmap() {
        for (int i = 0; i < buckets; i++) {
            contents.add(i, new LinkedList<>());
        }
    }

    public V get(K key) {
        int index = this.hash(key);

        List<Element> bucket = contents.get(index);

        for (Element element : bucket) {
            if (element.key.equals(key)) {
                return element.contents;
            }
        }

        throw new KeyNotFoundException("Could not find element with key " + key, key.toString());
    }

    public void add(K key, V value) {
        addElement(key, value);

        double load = load();
        if (load >= RESIZE_LIMIT) {
            System.out.println("Resizing due to load: " + load);
            resize();
        } else {
            System.out.println("No resize, load: " + load);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < contents.size(); i++) {
            builder.append(i).append(": ");
            List<Element> row = contents.get(i);

            for (Element element : row) {
                builder.append(element.key).append(" - ");
            }

            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

    private void resize() {
        int newSize = buckets * 2;
        ArrayList<List<Element>> newMap = new ArrayList<>(newSize);

        for (int i = 0; i < newSize; i++) {
            newMap.add(i, new LinkedList<>());
        }

        for (int i = 0; i < contents.size(); i++) {
            List<Element> row = contents.get(i);
            for (Element element: row){
                List<Element> newBucket = newMap.get(this.hash(element.key));
                newBucket.add(element);
            }
        }

        buckets = newSize;
        contents = newMap;
    }

    private void addElement(K key, V value) {
        int index = this.hash(key);

        List<Element> row = contents.get(index);
        row.add(new Element(key, value));
        entries = entries + 1;
    }

    private double load() {
        return (float)entries / buckets;
    }

    private int hash(K key) {
        int hash = key.hashCode();
        return (hash & 0x7FFFFFFF) % buckets;
    }

    public static class KeyNotFoundException extends RuntimeException {
        String key;

        KeyNotFoundException(String message, String key) {
            super(message);
            this.key = key;
        }
    }

    private final class Element {
        V contents;
        K key;

        private Element(K key, V value) {
            this.key = key;
            this.contents = value;
        }
    }
}


package be.wyckd.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class Hashmap<K, V> {
    private static int INITAL_CAPACITY = 50;

    private ArrayList<List<Element>> contents = new ArrayList<>(INITAL_CAPACITY);

    public Hashmap(){
        for(int i = 0; i < INITAL_CAPACITY; i++){
            contents.add(i, new LinkedList<>());
        }
    }

    public V get(K key){
        int index = this.hash(key);

        List<Element> bucket = contents.get(index);

        for(Element element : bucket){
            if( element.key.equals(key) ){
                return element.contents;
            }
        }

        throw new KeyNotFoundException("Could not find element with key " + key, key.toString());
    }

    public void add(K key, V value){
        int index = this.hash(key);

        List<Element> row = contents.get(index);
        row.add(new Element(key, value));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < contents.size(); i++){
            builder.append(i).append(": ");
            List<Element> row = contents.get(i);

            for(Element element : row){
                builder.append(element.key).append(" - ");
            }

            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

    private int hash(K key) {
        int hash = key.hashCode();
        return (hash & 0x7FFFFFFF) % INITAL_CAPACITY;
    }

    public static class KeyNotFoundException extends RuntimeException {
        String key;

        KeyNotFoundException(String message, String key){
            super(message);
            this.key = key;
        }
    }

    private final class Element {
        V contents;
        K key;

        private Element(K key, V value){
            this.key = key;
            this.contents = value;
        }
    }
}


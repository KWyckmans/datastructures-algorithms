package be.wyckd.util;

public class Person {
    private String name;

    private Person(String name){
        this.name = name;
    }

    public static Person from(String name){
        return new Person(name);
    }

    public String getName() {
        return name;
    }
}

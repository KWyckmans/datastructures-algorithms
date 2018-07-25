package be.wyckd.datastructures;

import be.wyckd.util.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;

import static org.junit.Assert.*;

public class HashmapTest {
    private Hashmap<String, Person> map;

    @Before
    public void setUp(){
        this.map = new Hashmap<>();
    }


    @Test(expected = Hashmap.KeyNotFoundException.class)
    public void getElementThatDoesNotExist_shouldThrowException(){
        map.get("test");
    }
}
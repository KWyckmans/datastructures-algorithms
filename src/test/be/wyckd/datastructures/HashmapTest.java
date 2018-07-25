package be.wyckd.datastructures;

import be.wyckd.util.Person;
import org.junit.Before;
import org.junit.Test;

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
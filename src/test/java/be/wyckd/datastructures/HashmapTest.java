package be.wyckd.datastructures;

import be.wyckd.util.Person;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HashmapTest {
    private Hashmap<String, Person> map;
    private String key;
    private Person value;

    @Before
    public void setUp() {
        this.map = new Hashmap<>();
        this.key = "Kevin";
        this.value = Person.from(key);

        map.add(key, value);
    }


    @Test
    public void getKey_returnsValue() {
        Person retrievedPerson = map.get(key);
        assertThat(retrievedPerson, is(value));
    }

    @Test(expected = Hashmap.KeyNotFoundException.class)
    public void getKey_NotInMap_WithIdenticalHashcode_shouldThrowException() {
        map.add("Aa", value); // Aa and BB have identical hashcode
        map.get("BB");
    }

    @Test(expected = Hashmap.KeyNotFoundException.class)
    public void getElementThatDoesNotExist_shouldThrowException() {
        map.get("test");
    }
}
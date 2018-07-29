package be.wyckd.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<Integer> list;

    @Before
    public void setup(){
        list = new LinkedList<>();
    }

    @Test
    public void count_whenEmptyList_shouldReturnCorrectValue(){
        assertThat(list.count(), is(0));
    }

    @Test
    public void count_shouldReturnCorrectValue(){
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(3);

        assertThat(list.count(), is(4));
    }

    @Test
    public void insert_shouldAddItem(){
        list.insert(1);
        assertThat(list.count(), is(1));

        Optional<Integer> result = list.search(1);
        assertThat(result.get(), is(1));
    }

    @Test
    public void deletingHead_shouldRemoveItem(){
        list.insert(2);
        list.insert(4);

        list.delete(4);

        assertThat(list.count(), is(1));
        assertThat(list.search(4), is(Optional.empty()));
    }

    @Test
    public void deleteElement_shouldRemoveItem(){
        list.insert(2);
        list.insert(4);
        list.insert(8);

        list.delete(4);

        assertThat(list.count(), is(2));
        assertThat(list.search(4), is(Optional.empty()));
    }

    @Test
    public void popFront_shouldReturnFirstItem(){
        list.insert(2);
        list.insert(4);
        list.insert(8);

        int item = list.popFront();

        assertThat(item, is(8));
        assertThat(list.count(), is(2));
    }

    @Test
    public void popBack_shouldReturnLastItem(){
        list.insert(2);
        list.insert(4);
        list.insert(8);

        int item = list.popBack();

        assertThat(item, is(2));
        assertThat(list.count(), is(2));
    }
}

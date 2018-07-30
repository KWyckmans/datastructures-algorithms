package be.wyckd.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StackTest {
    private Stack<Integer> stack;

    @Before
    public void setUp(){
        stack = new Stack<>();
    }

    @Test
    public void pushItem_shouldAddItem(){
        stack.push(1);

        assertThat(stack.pop(), is(1));
    }

    @Test
    public void popItem_shouldBeInLifoOrder(){
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }
}
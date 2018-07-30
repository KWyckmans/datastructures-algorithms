package be.wyckd.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QueueTest {
    private Queue<Integer> queue;

    @Before
    public void setUp(){
        queue = new Queue<>();
    }

    @Test
    public void enqueElement_shouldAddElement(){
        queue.enqueue(5);

        assertThat(queue.dequeue(), is(5));
    }

    @Test
    public void dequeue_shouldPopElements_inOrder(){
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(9);

        assertThat(queue.dequeue(), is(5));
        assertThat(queue.dequeue(), is(7));
        assertThat(queue.dequeue(), is(9));
    }
}
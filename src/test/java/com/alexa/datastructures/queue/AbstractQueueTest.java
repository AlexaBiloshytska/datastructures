package com.alexa.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractQueueTest {

    private Queue queue = getQueue();
    private Queue emptyQueue = getQueue();

    public abstract Queue getQueue();

    @Before
    public void setUp() {
        assertEquals(0, queue.size());
        assertEquals(null, queue.peek());

        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        queue.enqueue('f');
    }

    @Test
    public void testEnqueueAndDequeue() throws Exception {
        assertEquals(6, queue.size());

        assertEquals('a', queue.dequeue());
        assertEquals('b', queue.dequeue());

        assertEquals(4, queue.size());
    }

    @Test
    public void peek() throws Exception {
        assertEquals(6, queue.size());

        assertEquals('a', queue.peek());
        assertEquals('a', queue.peek());

        assertEquals(6, queue.size());

        assertEquals(null, emptyQueue.peek());

    }

    @Test
    public void iteratorTest(){
        queue.enqueue("A");
        queue.enqueue("B");


//        System.out.println("Ext");
//        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("Ext");
        for (Object o : queue ) {
            System.out.println(o);
        }
    }
}

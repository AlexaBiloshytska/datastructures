package com.alexa.datastructures.queue;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQueueTest {
    @Test
    public void testEnqueueAndDequeue() throws Exception {
        LinkedQueue queue = new LinkedQueue();

        queue.enqueue(10);
        queue.enqueue(0);

        assertEquals(10, queue.dequeue());
        assertEquals(0, queue.dequeue());
    }

    @Test
    public void size() throws Exception {
        LinkedQueue queue = new LinkedQueue();
        assertEquals(0, queue.size());

        queue.enqueue(10);
        queue.enqueue(10);
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1,queue.size());



    }

    @Test
    public void peek() throws Exception {
        LinkedQueue queue = new LinkedQueue();
        assertEquals(null, queue.peek());

        queue.enqueue(10);

        assertEquals(10, queue.peek());
        assertEquals(10, queue.peek());
    }

}
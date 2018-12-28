package com.alexa.datastructures.queue;

public class LinkedQueueTest extends AbstractQueueTest {
    @Override
    public Queue getQueue() {
        return new LinkedQueue<String>();
    }

}
package com.alexa.datastructures.queue;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQueueTest extends AbstractQueueTest {
    @Override
    public Queue getQueue() {
        return new LinkedQueue();
    }
}
package com.alexa.datastructures.queue;

public interface Queue {
    void enqueue(Object value);

    Object dequeue();

    int size();

    Object peek();
}

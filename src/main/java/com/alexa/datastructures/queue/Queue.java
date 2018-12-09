package com.alexa.datastructures.queue;

public interface Queue extends Iterable{
    void enqueue(Object value);

    Object dequeue();

    int size();

    Object peek();
}

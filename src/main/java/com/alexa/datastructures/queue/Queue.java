package com.alexa.datastructures.queue;


public interface Queue <T> extends Iterable<T>{

    void enqueue(T value);

    T dequeue();

    int size();

    T peek();
}

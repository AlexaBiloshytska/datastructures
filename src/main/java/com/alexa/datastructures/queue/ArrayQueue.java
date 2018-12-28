package com.alexa.datastructures.queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T>  {
    private int size;
    private T[] array;
    private static final int DEFAULT_CAPACITY = 5;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(T value) {
        if (size == array.length) {
            extendArray();
        }
        array[size] = value;
        size++;
    }

    private void extendArray() {
        int newCapacity = (int) (array.length * 1.5);
        T[] newArray = (T[])new Object[newCapacity];

        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;
    }

    @Override
    public T dequeue() {
        T firstElement = array[0];
        System.arraycopy(array, 1, array, 0, size-1);
        size--;
        return firstElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        return array[0];
    }

    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator{
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Object object = array[index];
            index++;
            return object;
        }
    }
}

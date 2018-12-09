package com.alexa.datastructures.queue;

import java.util.Iterator;

public class ArrayQueue implements Queue  {
    private int size;
    private Object [] array;
    private static final int DEFAULT_CAPACITY = 5;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(Object value) {
        if (size == array.length) {
            extendArray();
        }
        array[size] = value;
        size++;
    }

    private void extendArray() {
        int newCapacity = (int) (array.length * 1.5);
        Object[] newArray = new Object[newCapacity];

        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;
    }

    @Override
    public Object dequeue() {
        Object firstElement = array[0];
        System.arraycopy(array, 1, array, 0, size-1);
        size--;
        return firstElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object peek() {
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

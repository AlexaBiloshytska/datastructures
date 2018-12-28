package com.alexa.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T> {
    private T t;
    private static final int DEFAULT_CAPACITY = 5;
    private T[] array;
    private int size;

    public ArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }


    public ArrayList(int capacity) {

        array = (T[]) new Object[capacity];
    }


    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (size == array.length) {
            extendArray();
        }

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = value;
        size++;
    }

    @Override
    public T remove(int index) {
        validationIndex(index);

        T prev = array[index];
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size - 1] = null;
        size--;
        return prev;
    }

    @Override
    public T get(int index) {
        validationIndex(index);
        return array[index];
    }

    @Override
    public T set(T value, int index) {
        validationIndex(index);

        T prev = array[index];

        array[index] = value;
        return prev;
    }

    @Override
    public void clear() {
        for (int index = 0; index < size; index++) {
            array[index] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        if (value == null) {
            for (int index = 0; index < size; index++) {
                if (array[index] == null) {
                    return index;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (value.equals(array[index])) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int index = size - 1; index >= 0; index--) {
                if (array[index] == null) {
                    return index;
                }
            }
        } else {
            for (int index = size - 1; index >= 0; index--) {
                if (value.equals(array[index])) {
                    return index;
                }
            }
        }
        return -1;
    }

    private void extendArray() {
        int newCapacity = (int) (array.length * 1.5) + 1;
        T[] newArray = (T[]) new Object[newCapacity];

        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;
    }

    private void validationIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            String newElement = String.valueOf(array[i]); // Мы обезопасываем себя NullPointerException
            result.add(newElement);
        }
        return result.toString();
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator {
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




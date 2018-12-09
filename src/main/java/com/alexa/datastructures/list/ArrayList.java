package com.alexa.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList implements List {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }


    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
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
    public Object remove(int index) {
        validationIndex(index);

        Object prev = array[index];
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size - 1] = null;
        size--;
        return prev;
    }

    @Override
    public Object get(int index) {
       validationIndex(index);
       return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        validationIndex(index);

        Object prev = array[index];

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
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
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
    public int lastIndexOf(Object value){
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
        int newCapacity = (int) (array.length * 1.5);
        Object[] newArray = new Object[newCapacity];

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




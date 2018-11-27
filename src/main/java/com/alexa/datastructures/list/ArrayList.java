package com.alexa.datastructures.list;

public class ArrayList implements List  {
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
        if ( index > size){
            throw new IndexOutOfBoundsException();
        }

        if (size == array.length) {
            extendArray();
        }

        for (int i = size-1; i >= index; i--){
           array[i+1] = array[i];
        }

        array[index] = value;
        size++;
    }

    private void extendArray () {
        int newCapacity = (int) (array.length * 1.5);
        Object[] newArray = new Object[newCapacity];

        for (int index = 0; index < size; index++ ){
            Object value = array[index]; // Get value from old array
            newArray[index] = value; // Set value to new array
        }

        array = newArray;
    }

    @Override
    public Object remove(int index) {
        Object prev = array[index];

        for (int i = index; i < size; i++ ) {
            array[i]= array[i+1];
        }
        array[size - 1] = null;

        return prev;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object prev = array[index];

        array[index] = value;
        return prev;
    }

    @Override
    public void clear(){
        for (int index = 0; index < size; index++ ){
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
        for (int index = 0; index < size; index++){
            if (array[index]!= null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object value) {
        for (int index = 0; index < size; index++){
            if (array[index] == value) { // Read about Object.equals()
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value ) {
        for (int index = 0; index < size; index ++) {
            if ( array[index] == value ){
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int index = size-1; index >= 0; index--) {
            if ( array[index] == value ){
                return index;
            }
        }
        return -1;
    }

    @Override
    public  String toString() {
        String result = "[";
        for (int i = 0; i < size - 1; i++){
            result = result + array[i] + ", ";
        }
        result = result + array[size-1];
        return result + "]";
    }
}

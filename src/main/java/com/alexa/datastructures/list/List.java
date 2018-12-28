package com.alexa.datastructures.list;

public interface List<T> extends Iterable<T> {

    //add value to the end of the list
    void add(T value);

    // we can add value by index beween [ 0 - size]
    // otherwise throws new IndexOutOfBoundsException
    void add(T value, int index);

    // we can remove value by index beween [ 0 - size-1]
    // otherwise throws new IndexOutOfBoundsException
    T remove(int index);

    // we can get value by index beween [ 0 - size-1]
    // otherwise throws new IndexOutOfBoundsException
    T get(int index);


    // we can set value by index beween [ 0 - size-1]
    // otherwise throws new IndexOutOfBoundsException
    T set(T value, int index);

    void clear();

    int size();

    boolean isEmpty();

    boolean contains(T value);

    int indexOf(T value);

    int lastIndexOf(T value);

    //[A, B, C]

    String toString();
}

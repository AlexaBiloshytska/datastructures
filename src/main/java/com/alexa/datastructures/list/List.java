package com.alexa.datastructures.list;

public interface List {

    //add value to the end of the list
    void add(Object value);

    // we can add value by index beween [ 0 - size]
    // otherwise throws new IndexOutOfBoundsException
    void add(Object value, int index);

    // we can remove value by index beween [ 0 - size-1]
    // otherwise throws new IndexOutOfBoundsException
    Object remove(int index);

    // we can get value by index beween [ 0 - size-1]
    // otherwise throws new IndexOutOfBoundsException
    Object get(int index);


    // we can set value by index beween [ 0 - size-1]
    // otherwise throws new IndexOutOfBoundsException
    Object set(Object value, int index);

    void clear();

    int size();

    boolean isEmpty();

    boolean contains(Object value);

    int indexOf(Object value);

    int lastIndexOf(Object value);

    //[A, B, C]

    String toString();
}

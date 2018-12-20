package com.alexa.datastructures.map;

public interface Map {

    Object put (Object key, Object value);

    Object get (Object key);

    Object remove (Object key);
    // return value which was here

    boolean contains (Object key);

    Object putIfAbsent(Object key, Object value);
    //return the element which now is in the method or the inserted element

    int size();

}

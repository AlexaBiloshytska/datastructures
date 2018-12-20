package com.alexa.datastructures.map;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HashMap implements Map{
    private Entry[] buckets;
    private static final int DEFAULT_CAPACITY = 5;

    public HashMap() {
        buckets = new Entry[DEFAULT_CAPACITY];
    }

    public HashMap(int capacity) {
        buckets = new Entry[capacity];
    }


    // O(n) -> O(1)
    @Override
    public Object put(Object key, Object value) {
        int index = key.hashCode() % buckets.length;
        Object prevValue = buckets[index];
        buckets[index] = new Entry(key, value);
        return prevValue;
    }



    @Override
    public Object get(Object key) {
        int index = key.hashCode() % buckets.length;
        Entry entry = buckets[index];
        return entry.getValue();
    }

    @Override
    public Object remove(Object key) {
        int index = key.hashCode() % buckets.length;
        Entry entry = buckets[index];//wrapper
        buckets[index] = null;//link
        return entry.getValue();
    }

    @Override
    public boolean contains(Object key) {
        int index = key.hashCode() % buckets.length;
        return buckets[index] != null;
    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        int index = key.hashCode() % buckets.length;
        Entry entry = buckets[index];
        if ( entry == null) {
            return entry.getValue();
        }

        return put(key, value);
    }

    @Override
    public int size() {
        return buckets.length;
    }

    class Entry {
        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}

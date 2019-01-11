package com.alexa.datastructures.map;

public class HashMap implements Map {
    private static final double defaultLoadFactor = 0.75;
    private static final int DEFAULT_CAPACITY = 5;
    private int size;
    private Entry[] buckets;


    public HashMap() {
        buckets = new Entry[DEFAULT_CAPACITY];
    }

    public HashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    @Override
    public Object put(Object key, Object value) {
        if (size/buckets.length >= defaultLoadFactor){
            resize();
        }

        int index = key.hashCode() % buckets.length;
        Entry entry = buckets[index];

        if (entry == null) {
            buckets[index] = new Entry(key, value);
            size++;
            return null;
        }

        //update value if key matches
        Entry initialEntry = entry;
        while (entry != null){
            if (entry.getKey().equals(key)){
                Object prevValue = entry.getValue();
                entry.setValue(value);
                return prevValue;
            }
            entry = entry.getNext();
        }

        Entry newEntry = new Entry(key, value);
        buckets[index] = newEntry;
        newEntry.setNext(initialEntry); //set new entry to the beginning of the chain
        size++;
        return null;

    }

    @Override
    public Object get(Object key) {

        int index = key.hashCode() % buckets.length;
        Entry firstEntry = buckets[index];
        if (firstEntry == null){
            return null;
        }

        Entry searchedEntry = findChainedEntry(firstEntry, key);
        return searchedEntry != null ? searchedEntry.getValue() : null;
    }

    @Override
    public Object remove(Object key) {
        int index = key.hashCode() % buckets.length;

        Entry entry = buckets[index];
        Entry prevEntry = null;

        while (entry != null) {
            if (entry.getKey().equals(key)){
                if (prevEntry == null) {
                    buckets[index] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }

                entry.setNext(null);

                size--;
                return entry.getValue();
            }

            prevEntry = entry;
            entry = entry.getNext();
        }
        return null;
    }

    @Override
    public boolean contains(Object key) {
        int index = Math.abs(key.hashCode()) % buckets.length;
        return buckets[index] != null;
    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        int index = key.hashCode() % buckets.length;
        Entry entry = buckets[index];
        if (entry == null) {
            return put(key,value);
        }
        return entry.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private Entry findChainedEntry(Entry entry, Object key) {
        while (entry != null){
            if (entry.getKey().equals(key)){
                return entry;
            }
            entry = entry.getNext();
        }
        return null;
    }

    private void resize(){
        int newCapacity = (int)(buckets.length*1.5);
        Entry[] newArray = new Entry[newCapacity];
        System.arraycopy(buckets, 0, newArray, 0, size);

        Entry[] oldArray = buckets;
        buckets = newArray;

        for (Entry entry : oldArray) {
            while (entry != null) {
                put(entry.getKey(), entry.getValue()); // move to new bucket-array

                Entry prevEntry = entry;
                Entry nextEntry = entry.getNext();

                prevEntry.setNext(null);
                entry = nextEntry;
            }
        }
    }

    class Entry {
        private Entry next;
        private Object key;
        private Object value;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        Entry getNext() {
            return next;
        }

        void setNext(Entry next) {
            this.next = next;
        }

        Object getKey() {
            return key;
        }

        void setKey(Object key) {

            this.key = key;
        }

        Object getValue() {
            return value;
        }

        void setValue(Object value) {
            this.value = value;
        }
    }
}

package com.alexa.datastructures.map;


import java.util.ArrayList;
import java.util.List;

public class HashMap implements Map{
    private List<Entry> list = new ArrayList<>();

    // O(n) -> O(1)
    @Override
    public Object put(Object key, Object value) {
        for (Entry entry : list){
            if (entry.getKey().equals(key)){
                Object prevValue = entry.getValue();
                entry.setValue(value);
                return prevValue;
            }

        }
        list.add(new Entry(key, value));
        return null;
    }


    @Override
    public Object get(Object key) {
        for (Entry entry : list){
            if (entry.key.equals(key)){
                return entry.value;
            }

        }

        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public Object contains(Object key) {
        return null;
    }

    @Override
    public boolean putIfAbsent(Object key, Object value) {

        return false;
    }

    @Override
    public int size() {
        return 0;
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

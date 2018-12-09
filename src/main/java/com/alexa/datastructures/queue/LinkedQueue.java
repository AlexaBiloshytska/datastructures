package com.alexa.datastructures.queue;

import com.alexa.datastructures.list.LinkedList;

import java.util.Iterator;

public class LinkedQueue implements Queue {

    private Node head;
    private int size;

    @Override
    public void enqueue(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node pointer = head;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(newNode);
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }

        Node pointer = head;
        head = pointer.getNext();

        pointer.setNext(null);
        size--;

        return pointer.getValue();
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Object peek() {
        if (head == null) {
            return null;
        } else {
            return head.getValue();
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator {
        private Node currentNode = head;
        @Override
        public boolean hasNext() {
            if (head == null) {
                return false;
            }

            return currentNode != null;
        }

        @Override
        public Object next() {
            Object value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return value;
        }
    }
}


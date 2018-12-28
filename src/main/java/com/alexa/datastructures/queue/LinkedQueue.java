package com.alexa.datastructures.queue;

import com.alexa.datastructures.list.LinkedList;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T>{

    private Node<T> head;
    private int size;

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> pointer = head;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(newNode);
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }

        Node<T> pointer = head;
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
    public T peek() {
        if (head == null) {
            return null;
        } else {
            return head.getValue();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<T> {
        private Node<T> currentNode = head;
        @Override
        public boolean hasNext() {
            if (head == null) {
                return false;
            }

            return currentNode != null;
        }

        @Override
        public T next() {
            T value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return value;
        }
    }
}


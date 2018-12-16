package com.alexa.datastructures.list;

import javax.print.attribute.standard.NumberUp;
import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList implements List{

    private int size;
    private Node head;
    private Node tail;

    @Override
    public void add(Object value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }

        size++;
    }

    @Override
    public void add(Object value, int index) {
        validationIndex(index);
        Node node = new Node(value);

        if (size == 0 ){
            head = node;
            tail = node;
        } else if (index == 0) {
            node.next = head;
            head.previous = node;
            head = node;
        } else {
            Node pointer = getNode(index -1);
            if (pointer.next != null) {
                Node nextNode = pointer.next;
                nextNode.previous = node;
                node.next = nextNode;
            } else {
                tail = node;
            }
            pointer.next = node;
            node.previous = pointer;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        validationIndex(index);
        Node requiredNode = getNode(index);
        Node next = requiredNode.getNext();
        Node prev = requiredNode.getPrevious();
        prev.setNext(next);
        next.setPrevious(prev);

        requiredNode.setNext(null);
        requiredNode.setPrevious(null); // removed loitering!!

        Object  value = requiredNode.getValue();
        size--;
        return value;
    }

    @Override
    public Object get(int index) {
        validationIndex(index);

        Node requiredNode = getNode(index);
        return requiredNode.getValue();
    }

    @Override
    public Object set(Object value, int index) {
        validationIndex(index);

        Node reqiredNode = getNode(index);
        
        Object prevValue = reqiredNode.getValue();
        reqiredNode.setValue(value);
        return prevValue;
    }

    @Override
    public void clear() {
        head = tail = null;
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
        Node requiredNode = head;
        if (value == null){
            for (int i = 0; i < size; i++) {
                if (requiredNode.getValue()== null) {
                    return i;
                }
                requiredNode = requiredNode.getNext();
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (requiredNode.getValue().equals(value)){
                    return i;
                }
                requiredNode = requiredNode.getNext();
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node requiredNode = tail;
        if (value == null){
            for (int i = size-1; i >= 0; i--) {
                if (requiredNode.getValue() == null) {
                    return i;
                }
                requiredNode = requiredNode.getPrevious();
            }
        } else {
            for (int i = size-1; i >= 0; i--) {
                if (value.equals(requiredNode.getValue())){
                    return i;
                }
                requiredNode = requiredNode.getPrevious();
            }
        }
        return -1;
    }

    private void validationIndex (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNode(int index) {
        if (index < size/2) {
            Node nextNode = head;
            for (int i = 0; i < index; i++) {
                nextNode = nextNode.getNext();
            }
            return nextNode;
        } else {
            Node prevNode = tail;
            for (int i = size-1; i > index; i--) {
                prevNode = prevNode.getPrevious();
            }
            return prevNode;
        }

    }



    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        Node node = head;
        for (int i = 0; i < size; i++) {
            String newElement = String.valueOf(node.getValue()); // Мы обезопасываем себя NullPointerException
            node = node.getNext();
            result.add(newElement);
        }
        return result.toString();
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    class Node {
        private Node next;
        private Node previous;
        private Object value;

        public Node(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    private class LinkedListIterator implements Iterator {
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

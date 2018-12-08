package com.alexa.datastructures.list;

import javax.print.attribute.standard.NumberUp;
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

        if (head == null){
            head = node;
        } else {
            Node nextNode = head;
            for (int i = 0; i < index; i++) {
                nextNode = nextNode.getNext();
            }
            Node prevNode = nextNode.getPrevious();

            // Relink nodes
            nextNode.setPrevious(node);
            prevNode.setNext(node);

            node.setPrevious(prevNode);
            node.setNext(nextNode);
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        validationIndex(index);
        Node reqiredNode = head;
        for (int i = 0; i < index; i++){
            reqiredNode = reqiredNode.getNext();
        }
        Node next = reqiredNode.getNext();
        Node prev = reqiredNode.getPrevious();
        prev.setNext(next);
        next.setPrevious(prev);

        reqiredNode.setNext(null);
        reqiredNode.setPrevious(null); // removed loitering!!

        Object  value = reqiredNode.getValue();
        size--;
        return value;
    }

    @Override
    public Object get(int index) {
        validationIndex(index);

        Node requiredNode = head;
        for (int i = 0; i < index; i++){
            requiredNode = requiredNode.getNext();
        }
        return requiredNode.getValue();
    }

    @Override
    public Object set(Object value, int index) {
        validationIndex(index);

        Node reqiredNode = head;
        for (int i = 0; i < index; i++) {
            reqiredNode = reqiredNode.getNext();
        }
        Object prevValue = reqiredNode.getValue();
        reqiredNode.setValue(value);
        return prevValue;
    }

    @Override
    public void clear() {
        head = null;
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
}

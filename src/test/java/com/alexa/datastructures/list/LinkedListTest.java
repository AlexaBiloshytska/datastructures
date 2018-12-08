package com.alexa.datastructures.list;

import static org.junit.Assert.*;

public class LinkedListTest extends AbstractListTest{


    @Override
    protected List getList() {
        return new LinkedList();
    }
}
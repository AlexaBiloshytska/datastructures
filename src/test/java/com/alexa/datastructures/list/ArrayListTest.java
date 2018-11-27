package com.alexa.datastructures.list;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void add() throws Exception {
    }

    @Test
    public void add1() throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.add('a');
        arrayList.add('b');
        arrayList.add('c');
        arrayList.add('d');

        Assert.assertEquals(4,arrayList.size());

        arrayList.add('q', 1);
        assertEquals(5, arrayList.size());

        Object actual = arrayList.get(1);
        assertEquals('q',actual );

    }

    @Test
    public void remove() throws Exception {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');

        Object value = list.remove(1);
        Assert.assertEquals('b', value);

        Object actual = list.get(1);

        Assert.assertEquals('c', actual);
        Assert.assertEquals(3, list.size());

    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void set() throws Exception {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');

        Object prevValue = list.set('m',2);
        Assert.assertEquals('c', prevValue);
        Assert.assertEquals(4, list.size());

    }


    @Test //isEmpty and clear
    public void testIsEmptyAndClear() throws Exception {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');

        Object newArray = list.isEmpty();
        assertFalse( list.isEmpty());

        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void cointaints() throws Exception {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');

        assertTrue(list.contains('a'));

    }

    @Test
    public void indexOf() throws Exception {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('a');

        int valueIndex = list.indexOf('a');
        Assert.assertEquals(0, valueIndex);

        int valueIndexOne = list.indexOf('m');
        Assert.assertEquals(-1, valueIndexOne);

    }

    @Test
    public void lastIndexOf() throws Exception {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('a');

        int valueIndex = list.lastIndexOf('a');
        Assert.assertEquals(4, valueIndex);

        int valueIndexOne = list.lastIndexOf('k');
        Assert.assertEquals(-1, valueIndexOne);
    }

    @Test
    public void testToString() throws Exception {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');

        Assert.assertEquals("[a, b, c, d]", list.toString());
    }

    @Test
    public void testCapacity() {
        ArrayList list = new ArrayList(15);

        for (int i = 0; i < 10; i++) {
            list.add((char) (i + 96));
        }

        System.out.println(list.toString());
    }


    @Test
    public void testExtension() {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');

        Assert.assertEquals(2, list.size());

        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        list.add('g');

        Assert.assertEquals(7, list.size());
    }


}
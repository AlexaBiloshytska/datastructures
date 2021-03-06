package com.alexa.datastructures.list;

import com.alexa.datastructures.list.entity.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractListTest {
    private List<Character> list = getList();

    protected abstract List<Character> getList();

    @Before
    public void testBeforeOther() {
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
    }

    @Test
    public void add() throws Exception {
        Assert.assertEquals(4, list.size());

        list.add('q', 1);
        assertEquals(5, list.size());

        Object actual = list.get(1);
        assertEquals('q', actual);

    }

    @Test
    public void remove() throws Exception {
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
        Object prevValue = list.set('m', 2);
        Assert.assertEquals('c', prevValue);
        Assert.assertEquals(4, list.size());
    }


    @Test //isEmpty and clear
    public void testIsEmptyAndClear() throws Exception {
        Object newArray = list.isEmpty();
        assertFalse(list.isEmpty());

        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void cointaints() throws Exception {
        assertTrue(list.contains('a'));
    }

    @Test
    public void indexOf() throws Exception {
        int valueIndex = list.indexOf('a');
        Assert.assertEquals(0, valueIndex);

        int valueIndexOne = list.indexOf('m');
        Assert.assertEquals(-1, valueIndexOne);

        // find null value not exist
        //list.add(null, 2);
        System.out.println(list);
        Assert.assertEquals(-1, list.indexOf(null));

        // find null value exist
        list.add(null, 2);
        System.out.println(list);
        Assert.assertEquals(2, list.indexOf(null));
    }

    @Test
    public void lastIndexOf() throws Exception {
        list.add('a');
        int valueIndex = list.lastIndexOf('a');
        Assert.assertEquals(4, valueIndex);

        int valueIndexOne = list.lastIndexOf('k');
        Assert.assertEquals(-1, valueIndexOne);


        //if null value doesn't  exist
        System.out.println(list);
        Assert.assertEquals(-1, list.lastIndexOf(null));

        //if null value exists
        list.add(null, 3);
        System.out.println(list);
        Assert.assertEquals(3,list.lastIndexOf(null));
        Assert.assertEquals(4,list.lastIndexOf('d'));
        Assert.assertEquals(2,list.lastIndexOf('c'));
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals("[a, b, c, d]", list.toString());

        list.clear();
        Assert.assertEquals("[]", list.toString());

    }

    @Test
    public void testCapacity() {
        for (int i = 0; i < 10; i++) {
            list.add((char) (i + 96));
        }

        System.out.println(list.toString());
    }


    @Test
    public void testExtension() {
        Assert.assertEquals(4, list.size());

        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        list.add('g');

        Assert.assertEquals(9, list.size());
    }

    @Test
    public void testListWithDocumentEntity(){
        List<Document> documentList = new ArrayList<>();

        Document visa = new Document(1, "visa", "visa granted");
        Document certificate  = new Document(2, "marriage", "03.06.2017");
        Document birth = new Document(3, "birth", "28.02.1992");

        documentList.add(visa);
        documentList.add(certificate);
        documentList.add(birth);

        // Create another document with the same state
        Document visaTest = new Document(1, "visa", "visa granted");

        boolean contains = documentList.contains(visa);
        Assert.assertTrue(contains);

        boolean containsState = documentList.contains(visaTest);
        Assert.assertTrue(containsState);


    }

    @Test
    public void iteratorTest(){
        list.add('A');
        list.add('B');


//        System.out.println("Ext");
//        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("Ext");
        for (Object o : list) {
            System.out.println(o);
        }
    }


}

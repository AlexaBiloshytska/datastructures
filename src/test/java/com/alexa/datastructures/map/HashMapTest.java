package com.alexa.datastructures.map;
import org.junit.Assert;
import org.junit.Test;



public class HashMapTest {
    //Hashcode
    @Test
    public void testHashCode() {
        String cat = new String("Cat");
        String newCat = new String("Cat");

        Assert.assertEquals(cat.hashCode(), newCat.hashCode());
    }

    @Test
    public void testPutIfAbsent() {
        Map map = new HashMap();
        Assert.assertEquals(null, map.putIfAbsent("Cat", "value"));
        Assert.assertEquals("value", map.putIfAbsent("Cat", "newValue"));
        Assert.assertEquals("value", map.putIfAbsent("Cat", "12345"));
        Assert.assertEquals(1, map.size());

    }

    @Test
    public void testPut() {
        Map map = new HashMap();
        Assert.assertEquals(null, map.put("Cat", "Knopa"));
        Assert.assertEquals("Knopa", map.put("Cat","Nochka"));
        Assert.assertEquals("Nochka", map.put("Cat", "Ryzhyk"));
    }

    @Test
    public  void testGet() {
        Map map = new HashMap();
        Assert.assertEquals(null, map.get("key"));

    }

    @Test
    public void testRemove() {
        Map map = new HashMap();
        // Remove from first
        Assert.assertEquals(null, map.put("Dog", "Laska"));
        Assert.assertEquals("Laska", map.remove("Dog"));

        // Remove from chain
        map.put("four", "Some value which should be returned");
        map.put("eight", "Value I dont care");
        Assert.assertEquals("Some value which should be returned", map.get("four"));
        Assert.assertEquals("Some value which should be returned", map.remove("four"));
    }

    @Test
    public void testContains(){
        Map map = new HashMap();
        Assert.assertFalse("False", map.contains("key"));
        Assert.assertEquals(null, map.put("Cat", "Basilio"));
        Assert.assertTrue( map.contains("Cat"));
    }

    @Test
    public void testCapacity(){
        Map map = new HashMap();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);

        Assert.assertEquals(4, map.get("four"));
        Assert.assertEquals(8, map.get("eight"));

        Assert.assertEquals(1, map.get("one"));
        Assert.assertEquals(2, map.get("two"));
        Assert.assertEquals(3, map.get("three"));
        Assert.assertEquals(4, map.get("four"));
        Assert.assertEquals(5, map.get("five"));
        Assert.assertEquals(6, map.get("six"));
        Assert.assertEquals(7, map.get("seven"));
        Assert.assertEquals(8, map.get("eight"));
        Assert.assertEquals(9, map.get("nine"));
        Assert.assertEquals(10, map.get("ten"));
    }


}





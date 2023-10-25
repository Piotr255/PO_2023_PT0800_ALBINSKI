package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        //given
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test2 = new Vector2d(1,10);
        String expected1 = "(2,4)";
        String expected2 = "(1,10)";
        //when
        String usedMethod1 = test1.toString();
        String usedMethod2 = test2.toString();
        //then
        assertEquals(expected1,usedMethod1);
        assertEquals(expected2,usedMethod2);
    }

    @Test
    void precedes() {
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test11 = new Vector2d(10,10);
        Vector2d test2 = new Vector2d(3,8);
        Vector2d test22 = new Vector2d(1,1);

        assertTrue(test1.precedes(test11));
        assertFalse(test2.precedes(test22));


    }

    @Test
    void follows() {
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test11 = new Vector2d(10,10);
        Vector2d test2 = new Vector2d(3,8);
        Vector2d test22 = new Vector2d(1,1);

        assertTrue(test2.follows(test22));
        assertFalse(test1.follows(test11));


    }

    @Test
    void add() {
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test11 = new Vector2d(10,10);
        Vector2d test2 = new Vector2d(3,8);
        Vector2d test22 = new Vector2d(1,1);
        Vector2d expected1 = new Vector2d(12,14);
        Vector2d expected2 = new Vector2d(4,9);
        assertEquals(expected1,test1.add(test11));
        assertEquals(expected2,test2.add(test22));

    }

    @Test
    void subtract() {
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test11 = new Vector2d(10,10);
        Vector2d test2 = new Vector2d(3,8);
        Vector2d test22 = new Vector2d(1,1);
        Vector2d expected1 = new Vector2d(-8,-6);
        Vector2d expected2 = new Vector2d(2,7);
        assertEquals(expected1,test1.subtract(test11));
        assertEquals(expected2,test2.subtract(test22));

    }

    @Test
    void upperRight() {
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test11 = new Vector2d(10,10);
        Vector2d test2 = new Vector2d(3,8);
        Vector2d test22 = new Vector2d(10,2);
        Vector2d test3 = new Vector2d(2,2);
        Vector2d test33 = new Vector2d(1,1);
        Vector2d expected1 = new Vector2d(10,10);
        Vector2d expected2 = new Vector2d(10,8);
        Vector2d expected3 = new Vector2d(2,2);
        assertEquals(expected1,test1.upperRight(test11));
        assertEquals(expected2,test2.upperRight(test22));
        assertEquals(expected3,test3.upperRight(test33));
    }

    @Test
    void lowerLeft() {
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test11 = new Vector2d(10,10);
        Vector2d test2 = new Vector2d(3,8);
        Vector2d test22 = new Vector2d(10,2);
        Vector2d test3 = new Vector2d(2,2);
        Vector2d test33 = new Vector2d(1,1);
        Vector2d expected1 = new Vector2d(2,4);
        Vector2d expected2 = new Vector2d(3,2);
        Vector2d expected3 = new Vector2d(1,1);
        assertEquals(expected1,test1.lowerLeft(test11));
        assertEquals(expected2,test2.lowerLeft(test22));
        assertEquals(expected3,test3.lowerLeft(test33));
    }

    @Test
    void opposite() {
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test2 = new Vector2d(10,-10);
        Vector2d test3 = new Vector2d(0,0);
        Vector2d expected1 = new Vector2d(-2,-4);
        Vector2d expected2 = new Vector2d(-10,10);
        Vector2d expected3 = new Vector2d(0,0);
        assertEquals(expected1,test1.opposite());
        assertEquals(expected2,test2.opposite());
        assertEquals(expected3,test3.opposite());
    }

    @Test
    void testEquals() {
        Vector2d test1 = new Vector2d(2,4);
        Vector2d test3 = new Vector2d(2,4);
        Vector2d test4 = new Vector2d(2,1);
        Object test11 = test1;
        String test222 = "Hello";
        Object test22 = test222;
        assertTrue(test1.equals(test11));
        assertFalse(test1.equals(test22));
        assertTrue(test1.equals(test3));
        assertFalse(test1.equals(test4));
    }
}
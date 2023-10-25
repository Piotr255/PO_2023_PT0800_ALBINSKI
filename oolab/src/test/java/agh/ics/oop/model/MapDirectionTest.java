package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        //given
        MapDirection test1 = MapDirection.NORTH;
        MapDirection test2 = MapDirection.SOUTH;
        MapDirection test3 = MapDirection.EAST;
        MapDirection test4 = MapDirection.WEST;
        MapDirection expectedOutput1 = MapDirection.EAST;
        MapDirection expectedOutput2 = MapDirection.WEST;
        MapDirection expectedOutput3 = MapDirection.SOUTH;
        MapDirection expectedOutput4 = MapDirection.NORTH;
        //when
        MapDirection methodUsed1 = test1.next();
        MapDirection methodUsed2 = test2.next();
        MapDirection methodUsed3 = test3.next();
        MapDirection methodUsed4 = test4.next();
        //then
        assertEquals(expectedOutput1,methodUsed1);
        assertEquals(expectedOutput2,methodUsed2);
        assertEquals(expectedOutput3,methodUsed3);
        assertEquals(expectedOutput4,methodUsed4);
    }
    @Test
    void next1() {
        MapDirection test1 = MapDirection.NORTH;
        MapDirection expectedOutput1 = MapDirection.EAST;
        MapDirection methodUsed1 = test1.next();
        assertEquals(expectedOutput1,methodUsed1);
    }
    @Test
    void next2() {
        MapDirection test2 = MapDirection.SOUTH;
        MapDirection expectedOutput2 = MapDirection.WEST;
        MapDirection methodUsed2 = test2.next();
        assertEquals(expectedOutput2,methodUsed2);
    }
    @Test
    void next3() {
        MapDirection test3 = MapDirection.EAST;
        MapDirection expectedOutput3 = MapDirection.SOUTH;
        MapDirection methodUsed3 = test3.next();
        assertEquals(expectedOutput3,methodUsed3);
    }
    @Test
    void next4() {
        MapDirection test4 = MapDirection.WEST;
        MapDirection expectedOutput4 = MapDirection.NORTH;
        MapDirection methodUsed4 = test4.next();
        assertEquals(expectedOutput4,methodUsed4);
    }


    @Test
    void previous() {
        //given
        MapDirection test1 = MapDirection.NORTH;
        MapDirection test2 = MapDirection.SOUTH;
        MapDirection test3 = MapDirection.EAST;
        MapDirection test4 = MapDirection.WEST;
        MapDirection expectedOutput1 = MapDirection.WEST;
        MapDirection expectedOutput2 = MapDirection.EAST;
        MapDirection expectedOutput3 = MapDirection.NORTH;
        MapDirection expectedOutput4 = MapDirection.SOUTH;
        //when
        MapDirection methodUsed1 = test1.previous();
        MapDirection methodUsed2 = test2.previous();
        MapDirection methodUsed3 = test3.previous();
        MapDirection methodUsed4 = test4.previous();
        //then
        assertEquals(expectedOutput1,methodUsed1);
        assertEquals(expectedOutput2,methodUsed2);
        assertEquals(expectedOutput3,methodUsed3);
        assertEquals(expectedOutput4,methodUsed4);
    }

    @Test
    void previous1() {
        MapDirection test1 = MapDirection.NORTH;
        MapDirection expectedOutput1 = MapDirection.WEST;
        MapDirection methodUsed1 = test1.previous();
        assertEquals(expectedOutput1,methodUsed1);
    }
    @Test
    void previous2() {
        MapDirection test2 = MapDirection.SOUTH;
        MapDirection expectedOutput2 = MapDirection.EAST;
        MapDirection methodUsed2 = test2.previous();
        assertEquals(expectedOutput2,methodUsed2);
    }
    @Test
    void previous3() {
        MapDirection test3 = MapDirection.EAST;
        MapDirection expectedOutput3 = MapDirection.NORTH;
        MapDirection methodUsed3 = test3.previous();
        assertEquals(expectedOutput3,methodUsed3);
    }
    @Test
    void previous4() {
        MapDirection test4 = MapDirection.WEST;
        MapDirection expectedOutput4 = MapDirection.SOUTH;
        MapDirection methodUsed4 = test4.previous();
        assertEquals(expectedOutput4,methodUsed4);
    }

}
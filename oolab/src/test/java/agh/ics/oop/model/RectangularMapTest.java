package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void exampleTest() throws PositionAlreadyOccupiedException {
        RectangularMap testMap = new RectangularMap(10,10);
        Animal animal = new Animal(new Vector2d(5,5));
        Animal animal1 = new Animal(new Vector2d(2,7));
        testMap.place(animal);
        testMap.place(animal1);
        testMap.move(animal,MoveDirection.LEFT);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal1,MoveDirection.BACKWARD);
        System.out.println(testMap);
        assertFalse(testMap.canMoveTo(new Vector2d(-1,-1)));
        assertTrue(testMap.isOccupied(new Vector2d(0,5)));
        assertEquals(animal,testMap.objectAt(new Vector2d(0,5)));
        assertTrue(testMap.isOccupied(new Vector2d(2,6)));
        assertEquals(animal1,testMap.objectAt(new Vector2d(2,6)));
        System.out.println(testMap.getElements());
    }

}
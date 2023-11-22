package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void exampleGrassTest() {
        GrassField testMap = new GrassField(10);
        Animal animal = new Animal(new Vector2d(5,5));
        Animal animal1 = new Animal(new Vector2d(2,8));
        testMap.place(animal);
        testMap.place(animal1);
        System.out.println(testMap);
        testMap.move(animal,MoveDirection.LEFT);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal,MoveDirection.FORWARD);
        testMap.move(animal1,MoveDirection.BACKWARD);
        System.out.println(testMap);
        assertTrue(testMap.canMoveTo(new Vector2d(2,7))); //wejście na trawę
        assertTrue(testMap.isOccupied(new Vector2d(1,10))); //jakaś trawa
        assertEquals(animal,testMap.objectAt(new Vector2d(-1,5))); //przemieszczenie animal
        assertTrue(testMap.isOccupied(new Vector2d(2,6))); //trawa na polu
        assertEquals(animal1,testMap.objectAt(new Vector2d(2,6))); //zwierzę na polu
    }
}
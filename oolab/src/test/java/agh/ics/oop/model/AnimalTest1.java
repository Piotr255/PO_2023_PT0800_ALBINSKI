package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest1 {

    @Test
    void testToString() {
        MoveValidator validator = new RectangularMap(10, 10);
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT,validator);
        assertEquals("W",animal.toString());
    }

    @Test
    void isAt() {
        Animal animal1 = new Animal(new Vector2d(2,3));
        assertTrue(animal1.isAt(new Vector2d(2,3)));
        assertFalse(animal1.isAt(new Vector2d(1,4)));
    }

    @Test
    void move() {
        MoveValidator validator = new RectangularMap(5, 5);
        Animal animal1 = new Animal(new Vector2d(2,3));
        Animal animal2 = new Animal(new Vector2d(0,0));
        Animal animal3 = new Animal(new Vector2d(4,4));
        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.BACKWARD,validator);
        animal1.move(MoveDirection.RIGHT,validator);
        animal1.move(MoveDirection.FORWARD,validator);
        animal1.move(MoveDirection.BACKWARD,validator);
        animal1.move(MoveDirection.BACKWARD,validator);
        animal1.move(MoveDirection.LEFT,validator);
        animal2.move(MoveDirection.BACKWARD,validator);
        animal2.move(MoveDirection.LEFT,validator);
        animal2.move(MoveDirection.FORWARD,validator);
        animal3.move(MoveDirection.FORWARD,validator);
        animal3.move(MoveDirection.LEFT,validator);
        animal3.move(MoveDirection.BACKWARD,validator);

        assertEquals(new Vector2d(3,2),animal1.getPosition());
        assertEquals(MapDirection.WEST,animal1.getOrientation());
        assertEquals(new Vector2d(0,0),animal2.getPosition());
        assertEquals(new Vector2d(4,4),animal3.getPosition());
    }


}
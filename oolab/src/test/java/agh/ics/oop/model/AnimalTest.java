package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testToString() {
        Animal animal1 = new Animal(new Vector2d(2,3));
        assertEquals("Północ (2,3)", animal1.toString());
    }

    @Test
    void isAt() {
        Animal animal1 = new Animal(new Vector2d(2,3));
        assertTrue(animal1.isAt(new Vector2d(2,3)));
        assertFalse(animal1.isAt(new Vector2d(1,4)));
    }

    @Test
    void move() {  //czy zwierzę ma właściwą orientację, czy zwierzę przemieszcza się na właściwe pozycję oraz sprawdzam nie wychodzenie poza granice
        Animal animal1 = new Animal(new Vector2d(2,3));
        Animal animal2 = new Animal(new Vector2d(0,0));
        Animal animal3 = new Animal(new Vector2d(4,4));
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.LEFT);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.LEFT);
        animal2.move(MoveDirection.FORWARD);
        animal3.move(MoveDirection.FORWARD);
        animal3.move(MoveDirection.LEFT);
        animal3.move(MoveDirection.BACKWARD);

        assertEquals(new Vector2d(3,2),animal1.getPosition());
        assertEquals(MapDirection.WEST,animal1.getOrientation());
        assertEquals(new Vector2d(0,0),animal2.getPosition());
        assertEquals(new Vector2d(4,4),animal3.getPosition());
    }

}
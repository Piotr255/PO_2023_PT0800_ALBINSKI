package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

/*
    public Animal(){
        orientation = MapDirection.NORTH;
        position = new Vector2d(2,2);

    }

    public Animal(Vector2d position) {
        this();
        this.position = position;
    }*/

    public Animal() {
        this(new Vector2d(2, 2));
    }

    public Animal(Vector2d position) {
        this.orientation = MapDirection.NORTH;
        this.position = position;
    }

    @Override
    public String toString() {
        return orientation.toString();
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator){
        switch (direction) {
            case LEFT -> {
                orientation = orientation.previous();

            }
            case RIGHT -> {
                orientation = orientation.next();
            }
            case FORWARD -> {
                Vector2d possiblePosition = position.add(orientation.toUnitVector());
                if (validator.canMoveTo(possiblePosition)){
                    position = possiblePosition;
                }

            }
            case BACKWARD -> {
                Vector2d possiblePosition = position.subtract(orientation.toUnitVector());
                if (validator.canMoveTo(possiblePosition)){
                    position = possiblePosition;
                }

            }
        }
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }
}


package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);


    public Animal(){

    }

    public Animal(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return orientation + " " + position;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT -> {
                orientation = orientation.previous();

            }
            case RIGHT -> {
                orientation = orientation.next();
            }
            case FORWARD -> {
                Vector2d possiblePosition = position.add(orientation.toUnitVector());
                if (possiblePosition.getX() >= 0 && possiblePosition.getX() <= 4 && possiblePosition.getY() >= 0 && possiblePosition.getY() <= 4){
                    position = possiblePosition;
                }

            }
            case BACKWARD -> {
                Vector2d possiblePosition = position.subtract(orientation.toUnitVector());
                if (possiblePosition.getX() >= 0 && possiblePosition.getX() <= 4 && possiblePosition.getY() >= 0 && possiblePosition.getY() <= 4){
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


package agh.ics.oop.model;

import java.util.Vector;

public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(Vector2d position) {
        super(position + " is already occupied");
    }
}

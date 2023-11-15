package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class RectangularMap implements WorldMap{
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private int width;
    private int height;
    private Vector2d dimensionMin = new Vector2d(0,0);
    private Vector2d dimensionMax;
    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        dimensionMax = new Vector2d(width-1,height-1);

    }
    @Override
    public boolean canMoveTo(Vector2d position) {

        return !isOccupied(position) && position.precedes(dimensionMax) && position.follows(dimensionMin);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsValue(animal)){
            animal.move(direction);
            if (place(animal)){
                animals.remove(animal.getPosition());
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.getOrDefault(position, null);
    }

    @Override
    public String toString() {
        MapVisualizer mapToPrint = new MapVisualizer(this);
        return mapToPrint.draw(dimensionMin,dimensionMax);
    }
}

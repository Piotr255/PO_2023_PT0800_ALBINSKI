package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

abstract public class AbstractWorldMap implements WorldMap {
    protected  Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer mapToPrint = new MapVisualizer(this);
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
            animals.remove(animal.getPosition());
            animal.move(direction,this);
            animals.put(animal.getPosition(),animal);
        }
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public HashSet<WorldElement> getElements(){
        return new HashSet<WorldElement>(animals.values());
    }
}

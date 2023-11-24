package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

abstract public class AbstractWorldMap implements WorldMap {
    protected  Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this); //poprawić
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            //animal.placed = true;
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        //Vector2d position1 = animal.getPosition();
        if (animals.get(animal.getPosition()) == animal){     //animals.containsValue(animal) animalsanimal.getPosition()  animal.placed
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

    @Override
    public boolean canMoveTo(Vector2d position){
        return !animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }
}

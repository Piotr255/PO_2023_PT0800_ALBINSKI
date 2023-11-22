package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class GrassField implements WorldMap {
    private int grassNumber;
    private MapVisualizer mapToPrint = new MapVisualizer(this);
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private Map<Vector2d, Grass> grasses = new HashMap<>();
    public GrassField(int grassNumber) {
        this.grassNumber = grassNumber;
        double ceil = Math.ceil(Math.sqrt(grassNumber * 10));
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int) ceil,(int) ceil, grassNumber);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grasses.put(grassPosition, new Grass(grassPosition));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
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
            animals.remove(animal.getPosition());
            animal.move(direction,this);
            animals.put(animal.getPosition(),animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null){
            return animals.get(position);
        }
        else{
            return grasses.getOrDefault(position,null);
        }
    }
    @Override
    public String toString() {
        return mapToPrint.draw(dimensionMin,dimensionMax);
    }
}

package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

abstract public class AbstractWorldMap implements WorldMap {
    protected List<MapChangeListener> subscribers = new ArrayList<>();
    protected  Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    private final UUID id = UUID.randomUUID();

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            mapChanged("Zwierze zostalo postawione na" + animal.getPosition());
        }
        else{
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        //Vector2d position1 = animal.getPosition();
        if (animals.get(animal.getPosition()) == animal){     //animals.containsValue(animal) animalsanimal.getPosition()  animal.placed
            animals.remove(animal.getPosition());
            animal.move(direction,this);
            animals.put(animal.getPosition(),animal);
            mapChanged("Zwierze poruszylo sie na " + animal.getPosition());
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


    @Override
    public abstract Boundary getCurrentBounds();
    @Override
    public String toString() {
        Boundary boundary = getCurrentBounds();
        return mapVisualizer.draw(boundary.leftBottom(), boundary.rightTop());
    }

    public void subscribe(MapChangeListener observer){
        subscribers.add(observer);
    }
    public void unsubscribe(MapChangeListener observer){
        subscribers.remove(observer);
    }
    private void mapChanged(String message){
        for(MapChangeListener observer : subscribers){
            observer.mapChanged(this,message);
        }
    }


    @Override
    public UUID getId() {
        return id;
    }
}



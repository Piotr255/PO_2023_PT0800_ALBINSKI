package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private int grassNumber;
    private Map<Vector2d, Grass> grasses = new HashMap<>();
    public GrassField(int grassNumber) {
        this.grassNumber = grassNumber;
        double ceil = Math.floor(Math.sqrt(grassNumber * 10)+1);
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
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
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

    public Vector2d dimensionMax(){
/*        Set<Vector2d> keysAnimals = animals.keySet();
        Set<Vector2d> keysGrasses = grasses.keySet();*/
        int xValMax = Integer.MIN_VALUE;
        int yValMax = Integer.MIN_VALUE;
        for (Vector2d element: animals.keySet()){
            if (element.getX()>xValMax){
                xValMax = element.getX();
            }
            if (element.getY()>yValMax){
                yValMax = element.getY();
            }
        }
        for (Vector2d element: grasses.keySet()){
            if (element.getX()>xValMax){
                xValMax = element.getX();
            }
            if (element.getY()>yValMax){
                yValMax = element.getY();
            }
        }
        return new Vector2d(xValMax,yValMax);
    }
    public Vector2d dimensionMin(){
/*        Set<Vector2d> keysAnimals = animals.keySet();
        Set<Vector2d> keysGrasses = grasses.keySet();*/
        int xValMin = Integer.MAX_VALUE;
        int yValMin = Integer.MAX_VALUE;
        for (Vector2d element: animals.keySet()){
            if (element.getX()<xValMin){
                xValMin = element.getX();
            }
            if (element.getY()<yValMin){
                yValMin = element.getY();
            }
        }
        for (Vector2d element: grasses.keySet()){
            if (element.getX()<xValMin){
                xValMin = element.getX();
            }
            if (element.getY()<yValMin){
                yValMin = element.getY();
            }
        }
        return new Vector2d(xValMin,yValMin);
    }
    @Override
    public String toString() {
        return mapToPrint.draw(dimensionMin(),dimensionMax());
    }
    @Override
    public HashSet<WorldElement> getElements(){
        HashSet<WorldElement> firstSet = super.getElements();
        Set<WorldElement> grassesSet = new HashSet<>(grasses.values());
        firstSet.addAll(grassesSet);
        return firstSet;
    }
}

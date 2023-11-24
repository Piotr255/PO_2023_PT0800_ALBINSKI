package agh.ics.oop.model;

import java.util.Collections;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    private Vector2d dimensionMin;
    private Vector2d dimensionMax;
    public RectangularMap(int width, int height){
        dimensionMin  = new Vector2d(0,0);
        dimensionMax = new Vector2d(width-1,height-1);

    }
    @Override
    public boolean canMoveTo(Vector2d position) {

        return super.canMoveTo(position) && position.precedes(dimensionMax) && position.follows(dimensionMin);
    }
    @Override
    public String toString() {
        return mapVisualizer.draw(dimensionMin,dimensionMax);
    }

    public Map<Vector2d, Animal> getAnimals() { //do testów
        return Collections.unmodifiableMap(animals);
    }
}

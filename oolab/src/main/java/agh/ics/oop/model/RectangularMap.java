package agh.ics.oop.model;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class RectangularMap extends AbstractWorldMap{
    private final Boundary boundary;

    public RectangularMap(int width, int height){
        super();
        boundary = new Boundary(new Vector2d(0,0),new Vector2d(width-1,height-1));
    }
    @Override
    public boolean canMoveTo(Vector2d position) {

        return super.canMoveTo(position) && position.precedes(getCurrentBounds().rightTop()) && position.follows(getCurrentBounds().leftBottom());
    }


    public Map<Vector2d, Animal> getAnimals() { //do testów
        return Collections.unmodifiableMap(animals);
    }

    @Override
    public Boundary getCurrentBounds() {
        return boundary;
    }
}

package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private int grassNumber;
    private Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int grassNumber) {
        this.grassNumber = grassNumber;
        double ceil = Math.floor(Math.sqrt(grassNumber * 10) + 1);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int) ceil, (int) ceil, grassNumber, 12345L);
        for (Vector2d grassPosition : randomPositionGenerator) {
            grasses.put(grassPosition, new Grass(grassPosition));
        }
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        } else {
            return grasses.get(position);
        }
    }

    private Vector2d dimensionMax() {
        Vector2d ValsMax = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Vector2d element : animals.keySet()) {
            ValsMax = ValsMax.upperRight(element);
        }
        for (Vector2d element : grasses.keySet()) {
            ValsMax = ValsMax.upperRight(element);
        }
        return ValsMax;
    }
        private Vector2d dimensionMin() {
            Vector2d ValsMin = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
            for (Vector2d element : animals.keySet()) {
                ValsMin = ValsMin.lowerLeft(element);

            }
            for (Vector2d element : grasses.keySet()) {
                ValsMin = ValsMin.lowerLeft(element);

            }
            return ValsMin;
        }
        @Override
        public String toString () {
            return mapVisualizer.draw(dimensionMin(), dimensionMax());
        }
        @Override
        public HashSet<WorldElement> getElements () {
            HashSet<WorldElement> firstSet = super.getElements();
            firstSet.addAll(grasses.values());
            return firstSet;
        }
    }

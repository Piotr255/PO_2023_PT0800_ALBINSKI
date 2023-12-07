package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int counter = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        counter++;
        System.out.println(counter);
        System.out.println(worldMap.getId());
        System.out.println(message);
        System.out.println(worldMap);

    }
}

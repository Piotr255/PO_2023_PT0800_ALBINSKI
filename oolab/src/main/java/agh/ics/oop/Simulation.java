package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {
    private List<Vector2d> positions;
    private List<MoveDirection> directions;
    private WorldMap simulationMap;
    private List<Animal> animals = new ArrayList<>(); //ArrayList bo poniżej często interesuje mnie uzyskiwanie poszczególnych elementów o danym indeksie
    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap simulationMap){
        this.positions = positions;
        this.directions = directions;
        this.simulationMap = simulationMap;
        for(Vector2d position : this.positions){
            animals.add(new Animal(position));
        }
    }

    public void run(){
        int counter = 0;
        int animalsSize = animals.size();
        int modVal = 0;
        for(Animal animal: animals){
            simulationMap.place(animal);
        }
        System.out.println(simulationMap);
        for(MoveDirection direct : directions){
            modVal = counter % animalsSize;
            simulationMap.move(animals.get(modVal),direct);
            System.out.println(simulationMap);
            counter++;
        }

    }

     List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public WorldMap getSimulationMap() { //do testów
        return simulationMap;
    }
}


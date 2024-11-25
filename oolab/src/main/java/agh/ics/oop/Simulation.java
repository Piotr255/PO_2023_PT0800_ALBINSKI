package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation implements Runnable {
    private List<Vector2d> positions;
    private List<MoveDirection> directions;
    private WorldMap simulationMap;
    private List<Animal> animals = new ArrayList<>(); //ArrayList bo poniżej często interesuje mnie uzyskiwanie poszczególnych elementów o danym indeksie
    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap simulationMap){
        this.positions = positions;
        this.directions = directions;
        this.simulationMap = simulationMap;

    }
    /* dobrze animals.removeIf(animal -> !simulationMap.place(animal));*/

    /* dobrze
    Iterator<Animal> iterator = animals.iterator();
while (iterator.hasNext()) {
    Animal animal = iterator.next();
    if (!simulationMap.place(animal)) {
        iterator.remove();
    }
}
*/

    /*   źle  for(Animal animal: animals){
            if(!simulationMap.place(animal)){
                animals.remove(animal);
            }
        }*/
    public void run(){
        int counter = 0;
        int modVal = 0;
        for(Vector2d position : positions){
            Animal animal = new Animal(position);
            try{
                simulationMap.place(animal);
                Thread.sleep(750);
                animals.add(animal);
            }catch (PositionAlreadyOccupiedException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
                System.out.println("problemu z oczekiwaniem!");
            }
        }
        int animalsSize = animals.size();
//        System.out.println(simulationMap);
        for(MoveDirection direct : directions){
            modVal = counter % animalsSize;
            simulationMap.move(animals.get(modVal),direct);
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                System.out.println("problem z oczekiwaniem!");
            }
//            System.out.println(simulationMap);
            counter++;
        }

    }

     List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

     WorldMap getSimulationMap() { //do testów
        return simulationMap;
    }
}


package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Vector2d> positions;
    private List<MoveDirection> directions;

    private List<Animal> animals = new ArrayList<>();
    public Simulation(List<Vector2d> positions, List<MoveDirection> directions){
        this.positions = positions;
        this.directions = directions;
        for(Vector2d position : this.positions){
            animals.add(new Animal(position));
        }
    }

    public void run(){
        int i = 0;
        int j = animals.size();
        int k = 0;
        for(MoveDirection direct : directions){
            k = i % j;
            animals.get(k).move(direct);
            System.out.println("Zwierzę " + k + " : " +animals.get(k)); //animals.get(k).getPosition()
            i++;
        }

    }

}

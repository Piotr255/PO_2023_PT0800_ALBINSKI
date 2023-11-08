
package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;


public class World {

    public static void run(List<MoveDirection> params){
        for (MoveDirection param : params) {
            switch (param) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
            }
        }
    }
    public static void main(String[] args){
/*      Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.SOUTH);
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.EAST.toUnitVector());*/

        Animal dog = new Animal(new Vector2d(1, 1));
        System.out.println(dog);
        run(OptionsParser.convert(args));

        List<MoveDirection> directions = OptionsParser.convert(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();
    }
}


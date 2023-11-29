
package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static void main(String[] args) throws PositionAlreadyOccupiedException {
/*      Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.SOUTH);
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.EAST.toUnitVector());*/
/*
        Animal dog = new Animal(new Vector2d(1, 1));
        System.out.println(dog);
        run(OptionsParser.convert(args));

        List<MoveDirection> directions = OptionsParser.convert(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();
        */

        //sprawdzenie poprawności implementacji GrassField
  /*      Animal animal0 = new Animal();
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(1, 10));
        Animal animal3 = new Animal(new Vector2d(2, 6));
        GrassField testMap = new GrassField(10);
        System.out.println(testMap);
        testMap.place(animal0);
        testMap.place(animal1);
        testMap.move(animal0,MoveDirection.FORWARD);
        testMap.move(animal0,MoveDirection.FORWARD);
        testMap.move(animal0,MoveDirection.LEFT);
        testMap.move(animal0,MoveDirection.RIGHT);
        testMap.move(animal0,MoveDirection.RIGHT);
        testMap.move(animal1,MoveDirection.BACKWARD);

        testMap.place(animal2);
        testMap.place(animal3);
        testMap.move(animal3,MoveDirection.FORWARD);
        System.out.println(testMap);
        System.out.println(testMap.getElements());
*/


/*
        List<Vector2d> testRand = new ArrayList<>();

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(50, 50, 70);
        for(Vector2d grassPosition : randomPositionGenerator) {
            testRand.add( grassPosition);
        }
        System.out.println(testRand);
        System.out.println(testRand.size());

*/


        //List<MoveDirection> testlist = OptionsParser.convert(new String[]{"f", "a"});


        //observer testy
        Animal animal0 = new Animal();
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(1, 10));
        Animal animal3 = new Animal(new Vector2d(2, 6));
        GrassField testMap = new GrassField(10);
        testMap.subscribe(new ConsoleMapDisplay());
//        System.out.println(testMap);
        testMap.place(animal0);
        testMap.place(animal1);
        testMap.move(animal0,MoveDirection.FORWARD);
        testMap.move(animal0,MoveDirection.FORWARD);
        testMap.move(animal0,MoveDirection.LEFT);
        testMap.move(animal0,MoveDirection.RIGHT);
        testMap.move(animal0,MoveDirection.RIGHT);
        testMap.move(animal1,MoveDirection.BACKWARD);

        testMap.place(animal2);
        testMap.place(animal3);
        testMap.move(animal3,MoveDirection.FORWARD);

        //simulation wypisywanie observerem
        AbstractWorldMap simulationMap = new RectangularMap(5, 5);
        simulationMap.subscribe(new ConsoleMapDisplay());
        List<MoveDirection> directions = OptionsParser.convert(new String[]{"l","l","f","f"});
        List<Vector2d> positions = List.of(new Vector2d(2,2),new Vector2d(2,2),new Vector2d(4,4));
        Simulation simulation = new Simulation(positions, directions,simulationMap);
        simulation.run();
//        System.out.println(testMap);
//        System.out.println(testMap.getElements());


    }
}


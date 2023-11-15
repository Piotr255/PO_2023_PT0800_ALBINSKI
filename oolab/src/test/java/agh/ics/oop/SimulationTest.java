/*
package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void orientationtest(){
        List<MoveDirection> directions = OptionsParser.convert(new String[]{"l","f","r","r","d","l","q","l","f","f","f","f","f","f"});
        List<Vector2d> positions = List.of(new Vector2d(2,2),new Vector2d(1,1));

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();
        assertEquals(MapDirection.WEST,simulation.getAnimals().get(0).getOrientation());
        assertEquals(MapDirection.NORTH,simulation.getAnimals().get(1).getOrientation());
    }
    @Test
    void movingtest(){
        List<MoveDirection> directions = OptionsParser.convert(new String[]{"f","l","f","r","r","r","b"});
        List<Vector2d> positions = List.of(new Vector2d(2,2));
        List<Vector2d> positions1 = List.of(new Vector2d(2,1),new Vector2d(1,4));
        Simulation simulation = new Simulation(positions, directions);
        Simulation simulation1 = new Simulation(positions1, directions);
        simulation.run();
        simulation1.run();
        assertEquals(new Vector2d(1,4),
                simulation.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(1,3),
                simulation1.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(1,4),
                simulation1.getAnimals().get(1).getPosition());
    }
    @Test
    void borderstest(){
        List<MoveDirection> directions = OptionsParser.convert(new String[]{"b","b","r","b","b"});
        List<MoveDirection> directions1 = OptionsParser.convert(new String[]{"f","f","r","f","f"});
        List<Vector2d> positions = List.of(new Vector2d(0,0));
        List<Vector2d> positions1 = List.of(new Vector2d(4,4));
        Simulation simulation = new Simulation(positions, directions);
        Simulation simulation1 = new Simulation(positions1, directions1);
        simulation.run();
        simulation1.run();
        assertEquals(positions.get(0),
                simulation.getAnimals().get(0).getPosition());
        assertEquals(positions1.get(0),
                simulation1.getAnimals().get(0).getPosition());

    }
    @Test
    void inputunderstandingtest(){
        List<MoveDirection> directions = OptionsParser.convert(new String[]{"f","l","b","r","d"});
        List<MoveDirection> expecteddirections = List.of(MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.RIGHT);
        int i = 0;
        for(MoveDirection direction : expecteddirections){
            assertEquals(direction,directions.get(i));
            i++;
        }

    }



}*/

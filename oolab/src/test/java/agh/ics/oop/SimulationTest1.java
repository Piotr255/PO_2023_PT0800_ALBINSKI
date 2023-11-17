package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest1 {

    @Test

    void run(){
        WorldMap simulationMap = new RectangularMap(5, 5);
        List<MoveDirection> directions = OptionsParser.convert(new String[]{"l","l","f","f","d",});
        List<Vector2d> positions = List.of(new Vector2d(2,2),new Vector2d(2,2),new Vector2d(4,4));
        Simulation simulation = new Simulation(positions, directions,simulationMap);
        simulation.run();
        assertTrue(((RectangularMap) simulation.getSimulationMap()).getAnimals().containsKey(new Vector2d(1,2)));
        assertEquals(MapDirection.WEST,((RectangularMap) simulation.getSimulationMap()).getAnimals().get(new Vector2d(1,2)).getOrientation());
        assertTrue(((RectangularMap) simulation.getSimulationMap()).getAnimals().containsKey(new Vector2d(3,4)));
        assertEquals(MapDirection.WEST,((RectangularMap) simulation.getSimulationMap()).getAnimals().get(new Vector2d(3,4)).getOrientation());
    }


}
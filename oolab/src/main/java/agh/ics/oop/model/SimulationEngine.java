package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    private List<Simulation> simulations;
    private List<Thread> threads = new ArrayList<>();

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }
    public void runAsync() throws InterruptedException {
        for(Simulation simulation : simulations){
            Thread thread = new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
        awaitSimulationsEnd();
    }
    public void awaitSimulationsEnd() throws InterruptedException {
        for(Thread thread : threads){
            thread.join();
        }


    }
}

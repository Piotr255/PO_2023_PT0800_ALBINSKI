package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {

    @FXML
    private Label positionLabel;
    WorldMap worldMap;
    @FXML
    private Label infoLabel;

    @FXML
    private TextField textField;

    private void drawMap(WorldMap worldMap){
        infoLabel.setText(this.worldMap.toString());
    }
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            drawMap(worldMap);
            positionLabel.setText(message);
        });
    }

    public void onSimulationStartClicked(ActionEvent actionEvent) {
        RectangularMap simulationMap = new RectangularMap(5, 5);
        simulationMap.subscribe(this);
        this.setWorldMap(simulationMap);
        //List<MoveDirection> directions = OptionsParser.convert(new String[]{"l","l","r","f","f","f","f", "l", "r", "b"});
        String[] moves = textField.getText().split(" ");
        List<MoveDirection> directions = OptionsParser.convert(moves);
        List<Vector2d> positions = List.of(new Vector2d(2,2),new Vector2d(4,4));
        Simulation simulation = new Simulation(positions, directions,simulationMap);
        List<Simulation> simulations = new ArrayList<>();
        simulations.add(simulation);
        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        simulationEngine.runAsyncInThreadPool();
    }
}

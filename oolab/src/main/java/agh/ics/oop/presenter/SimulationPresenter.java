package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {

    private static final double CELL_HEIGHT = 40;
    private static final double CELL_WIDTH = 40;
    @FXML
    private GridPane mapGrid;
    @FXML
    private Label positionLabel;
    WorldMap worldMap;
    @FXML
    private Label infoLabel;

    @FXML
    private TextField textField;

    private void clearGrid() {
        mapGrid.getChildren().clear();
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }
    private void drawMap(WorldMap worldMap) {
        clearGrid();
        Boundary boundary = worldMap.getCurrentBounds();
        int xMin = boundary.leftBottom().getX();
        int xMax = boundary.rightTop().getX();
        int yMax = boundary.rightTop().getY();
        int yMin = boundary.leftBottom().getY();

        int columns = xMax - xMin + 1;
        int rows = yMax - yMin + 1;

        for (int i = 0; i <= columns; i++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }
        for (int i = 0; i <= rows; i++) {
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                Label cell;
                if (i == 0 && j == 0) {
                    cell = new Label("y/x");
                } else if (i == 0) {
                    cell = new Label(String.valueOf(xMin + j - 1));
                } else if (j == 0) {
                    cell = new Label(String.valueOf(yMax - i + 1));
                } else {
                    cell = createCell(xMin + j - 1, yMax - i + 1);
                }
                cell.setMinSize(CELL_WIDTH, CELL_HEIGHT);
                cell.setStyle("-fx-border-color: black; -fx-alignment: center;");
                mapGrid.add(cell, j, i);
            }
        }
    }


    private Label createCell(int i, int j) {
        WorldElement worldElement = worldMap.objectAt(new Vector2d(i,j));
        Label cell = new Label();
        if ( worldElement != null){
            cell.setText(worldElement.toString());
        }
        else{
            cell.setText("");
        }
        return cell;
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
        //RectangularMap simulationMap = new RectangularMap(5, 5);
        GrassField simulationMap = new GrassField(10);
        simulationMap.subscribe(this);
        this.setWorldMap(simulationMap);
        //List<MoveDirection> directions = OptionsParser.convert(new String[]{"l","l","r","f","f","f","f", "l", "r", "b"});
        String[] moves = textField.getText().split(" ");
        List<MoveDirection> directions = OptionsParser.convert(moves);
        List<Vector2d> positions = List.of(new Vector2d(2,2),new Vector2d(-4,4));
        Simulation simulation = new Simulation(positions, directions,simulationMap);
        List<Simulation> simulations = new ArrayList<>();
        simulations.add(simulation);
        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        simulationEngine.runAsyncInThreadPool();
    }
}

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
    private void drawMap(WorldMap worldMap){
        //infoLabel.setText(this.worldMap.toString());
        clearGrid();
        Boundary boundary = worldMap.getCurrentBounds();
        int columns = boundary.rightTop().getX() - boundary.leftBottom().getX() + 1;
        int rows = boundary.rightTop().getY() - boundary.leftBottom().getY() + 1;
        for(int i = 0; i <=rows; i++){
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
            for(int j = 0; j<=columns; j++) {
                if (i == 0){
                    mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
                }
                Node cell = createCell(i-1,columns-j, i, j);
                mapGrid.add(cell,i, j);

            }
            }

        }

    private Node createCell(int i, int j, int iMap, int jMap) {
        WorldElement worldElement = worldMap.objectAt(new Vector2d(i,j));
        Label cell = new Label();
        cell.setMinSize(CELL_WIDTH, CELL_HEIGHT);
        cell.setStyle("-fx-border-color: black; -fx-alignment: center;");
        if ( worldElement != null){
            cell.setText(worldElement.toString());
        }
        else if (iMap == 0 && jMap == 0){
            cell.setText("y/x");

        }
        else if (iMap == 0) {
            cell.setText(String.valueOf(j));
        }
        else if (jMap == 0) {
            cell.setText(String.valueOf(i));

        } else{
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

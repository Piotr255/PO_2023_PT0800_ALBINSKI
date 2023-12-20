package agh.ics.oop.presenter;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SimulationPresenter implements MapChangeListener {
    WorldMap worldMap;
    @FXML
    private Label infoLabel;

    @FXML
    private TextField textField;

    private void drawMap(){
        infoLabel.setText(worldMap.toString());
    }
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        drawMap();
    }

    public void onSimulationStartClicked(ActionEvent actionEvent) {
    }
}

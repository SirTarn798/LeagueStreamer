package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ku.cs.models.LeagueStreamer;
import ku.cs.models.LeagueStreamerList;
import ku.cs.services.FXRouter;
import ku.cs.services.LeagueStreamerHardCodeDatasource;

import java.io.IOException;

public class LeagueStreamerListController {
    @FXML private ListView<LeagueStreamer> leagueStreamerListView;

    @FXML
    Label nameLabel;
    @FXML
    Label laneLabel;
    @FXML
    Label killsLabel;
    @FXML
    Label deathsLabel;
    @FXML
    Label assistsLabel;
    @FXML
    Label kdaLabel;
    @FXML
    Label errorLabel;
    @FXML
    TextField addKillsTextField;
    @FXML
    TextField addDeathsTextField;
    @FXML
    TextField addAssistsTextField;
    @FXML
    AnchorPane infoPanel;

    private LeagueStreamerList leagueStreamerList;
    private LeagueStreamer selectedStreamer;

    @FXML
    protected void onStreamerListToMe() {
        try {
            FXRouter.goTo("me-profile");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onStreamerListToAddStreamer() {
        try {
            FXRouter.goTo("add-streamer");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    public void initialize() {
        infoPanel.setVisible(false);
        errorLabel.setText("");
        clearStreamerInfo();
        LeagueStreamerHardCodeDatasource datasource = new LeagueStreamerHardCodeDatasource();
        leagueStreamerList = datasource.readData();
        showList(leagueStreamerList);
        leagueStreamerListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<LeagueStreamer>() {
            @Override
            public void changed(ObservableValue<? extends LeagueStreamer> observable, LeagueStreamer oldValue, LeagueStreamer newValue) {
                if (newValue == null) {
                    clearStreamerInfo();
                    selectedStreamer = null;
                    infoPanel.setVisible(false);
                } else {
                    showStreamerInfo(newValue);
                    selectedStreamer = newValue;
                    infoPanel.setVisible(true);
                }
            }
        });
    }

    private void showList(LeagueStreamerList leagueStreamerList) {
        leagueStreamerListView.getItems().clear();
        leagueStreamerListView.getItems().addAll(leagueStreamerList.getStreamers());
    }

    private void showStreamerInfo(LeagueStreamer Streamer) {
        nameLabel.setText(Streamer.getName());
        laneLabel.setText(Streamer.getLane());
        killsLabel.setText(""+Streamer.getKills());
        deathsLabel.setText(""+Streamer.getDeaths());
        assistsLabel.setText(""+Streamer.getAssists());
        kdaLabel.setText((Streamer.getKda() == -1)? "Perfect" : ""+Streamer.getKda());

    }

    private void clearStreamerInfo() {
        nameLabel.setText("");
        laneLabel.setText("");
        killsLabel.setText("");
        deathsLabel.setText("");
        assistsLabel.setText("");
        kdaLabel.setText("");
    }

    @FXML
    public void onAddKDAButtonClick() {
        if(selectedStreamer != null) {
            String killsText = addKillsTextField.getText();
            String deathsText = addDeathsTextField.getText();
            String assistsText = addAssistsTextField.getText();
            String errorMessage = "";
            try {
                int kills = Integer.parseInt(killsText);
                int deaths = Integer.parseInt(deathsText);
                int assists = Integer.parseInt(assistsText);
                leagueStreamerList.addKills(selectedStreamer.getName(), kills);
                leagueStreamerList.addDeaths(selectedStreamer.getName(), deaths);
                leagueStreamerList.addAssists(selectedStreamer.getName(), assists);
                showStreamerInfo(selectedStreamer);
            } catch(NumberFormatException e) {
                errorMessage = "Please insert number value";
                errorLabel.setText(errorMessage);
            } finally {
                if(errorMessage.equals("")) {
                    addKillsTextField.setText("");
                    addDeathsTextField.setText("");
                    addAssistsTextField.setText("");
                    errorLabel.setText("");
                }
            }
        }
        else {
            addKillsTextField.setText("");
            addDeathsTextField.setText("");
            addAssistsTextField.setText("");
            errorLabel.setText("");
        }
    }
}
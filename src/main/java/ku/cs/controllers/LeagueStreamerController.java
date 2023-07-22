package ku.cs.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.models.LeagueStreamer;
import ku.cs.services.FXRouter;

import java.io.IOException;


public class LeagueStreamerController {

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
    public void initialize() {
        LeagueStreamer streamer = new LeagueStreamer("Thebausffs", "Top", 10,18,5);
        showStreamer(streamer);
    }

    @FXML
    protected void onLeagueStreamerButtonClick() {
        try {
            FXRouter.goTo("me-profile");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showStreamer(LeagueStreamer streamer) {
        nameLabel.setText(streamer.getName());
        laneLabel.setText(streamer.getLane());
        killsLabel.setText(""+streamer.getKills());
        deathsLabel.setText(""+streamer.getDeaths());
        assistsLabel.setText(""+streamer.getAssists());
        kdaLabel.setText(""+String.format("%.2f",streamer.getKda()));
    }


}

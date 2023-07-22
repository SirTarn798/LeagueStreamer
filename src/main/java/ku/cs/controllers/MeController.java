package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Me;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class MeController {
    @FXML
    Label nameLabel;

    @FXML
    Label idLabel;


    @FXML
    Label nickNameLabel;

    @FXML
    public void initialize() {
        Me me = new Me("6510405407", "Jirayu Oaurai", "Tarn");
        showMe(me);
    }

    @FXML
    protected void onMeButtonClickToStreamerProfile() {
        try {
            FXRouter.goTo("league-streamer-profile");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onMeButtonClickToStreamerList() {
        try {
            FXRouter.goTo("league-streamer-list");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showMe(Me me) {

        nameLabel.setText(me.getName());
        idLabel.setText(me.getId());
        nickNameLabel.setText(me.getNickName());
    }


}

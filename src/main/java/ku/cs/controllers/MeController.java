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
    Label ageLabel;

    @FXML
    Label nickNameLabel;

    @FXML
    public void initialize() {
        Me me = new Me("6510405407", "Jirayu Oaurai", "Tarn", 2004);
        showMe(me);
    }

    @FXML
    protected void onMeButtonClick() {
        try {
            FXRouter.goTo("league-streamer-profile");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showMe(Me me) {

        nameLabel.setText(me.getName());
        idLabel.setText(me.getId());
        ageLabel.setText(""+me.getAge());
        nickNameLabel.setText(me.getNickName());
    }


}

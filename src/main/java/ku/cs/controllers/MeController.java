package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Me;
import ku.cs.services.FXRouter;
import java.io.IOException;
import ku.cs.controllers.NavigationBarController;

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

    private void showMe(Me me) {

        nameLabel.setText(me.getName());
        idLabel.setText(me.getId());
        nickNameLabel.setText(me.getNickName());
    }


}

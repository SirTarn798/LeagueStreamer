package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Me;

public class MeController {
    @FXML
    Label nameLabel;

    @FXML
    Label idLabel;

    @FXML
    Label ageLabel;

    @FXML
    public void initialize() {
        Me me = new Me("6510405407", "Jirayu Oaurai", 2004);
        showMe(me);
    }

    private void showMe(Me me) {

        nameLabel.setText(me.getName());
        idLabel.setText(me.getId());
        ageLabel.setText(""+me.getAge());
    }
}

package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class NavigationBarController {
    @FXML
    Button goToMeButton;
    @FXML
    Button goToStreamerListButton;
    @FXML
    Button goToStreamerProfileButton;
    @FXML
    AnchorPane ap;

    @FXML
    protected void goToStreamerProfile() {
        try {
            FXRouter.goTo("league-streamer-profile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void goToStreamerList() {
        try {
            FXRouter.goTo("league-streamer-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void goToMe() {
        try {
            FXRouter.goTo("me-profile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


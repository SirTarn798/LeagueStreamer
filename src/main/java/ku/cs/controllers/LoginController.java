package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.models.CurrentUser;
import ku.cs.services.FXRouter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginController {
    private String filePath = "src/main/java/ku/cs/services/LoginData.csv";
    private String ID;
    private String PASS;
    @FXML
    TextField idTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    Label errorLabel;
    @FXML
    public CurrentUser login() {
        CurrentUser currentUser = null;
        try {
            Scanner x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                ID = x.next();
                PASS = x.next();
                if(ID.trim().equals(idTextField.getText()) && PASS.trim().equals(passwordTextField.getText())) {
                    currentUser = new CurrentUser(ID);
                    try {
                        FXRouter.goTo("me-profile");
                    }
                    catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return currentUser;
                }
            }
            errorLabel.setText("Wrong ID or password!");
            idTextField.setText("");
            passwordTextField.setText("");
        } catch (Exception e) {
        }
        return currentUser;
    }
    @FXML
    private void goToRegister() {
        try {
            FXRouter.goTo("register");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

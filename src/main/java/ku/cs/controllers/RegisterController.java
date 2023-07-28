package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.services.FXRouter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterController {

    private String filePath = "src/main/java/ku/cs/services/LoginData.csv";
    @FXML
    TextField idTextField;
    @FXML
    PasswordField passwordTextField;
    @FXML
    PasswordField passwordAgainTextField;
    @FXML
    TextField fullNameTextField;
    @FXML
    Label errorLabel;
    @FXML
    private void register() {
        String id = idTextField.getText();
        String password = passwordTextField.getText();
        String password2 = passwordAgainTextField.getText();
        String fullName = fullNameTextField.getText();
        if(!password.equals(password2)){
            errorLabel.setText("Please make sure you type the correct passwords.");
            passwordTextField.setText("");
            passwordAgainTextField.setText("");
            return;
        }
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw =  new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(id+","+password);
            pw.flush();
            pw.close();
            goToLogin();
        } catch (IOException e) {
        }


    }
    @FXML
    private void goToLogin() {
        try {
            FXRouter.goTo("login");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

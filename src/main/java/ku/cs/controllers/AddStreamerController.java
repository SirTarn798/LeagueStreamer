package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.services.FXRouter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddStreamerController {
    private String filePath = "src/main/java/ku/cs/services/LeagueStreamers.csv";git 

    @FXML
    Label errorLabel;
    @FXML
    TextField nameTextField;
    @FXML
    TextField laneTextField;
    @FXML
    TextField killsTextField;
    @FXML
    TextField deathsTextField;
    @FXML
    TextField assistsTextField;

    @FXML
    public void initialize() {

    }

    @FXML
    protected void onAddStreamerToMe() {
        try {
            FXRouter.goTo("me-profile");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void addStreamer() {
        String name = nameTextField.getText();
        String lane = laneTextField.getText();
        String kills = killsTextField.getText();
        String deaths = deathsTextField.getText();
        String assists = assistsTextField.getText();
        int checkIsInt;
        try {
            checkIsInt = Integer.parseInt(kills);
            checkIsInt = Integer.parseInt(deaths);
            checkIsInt = Integer.parseInt(assists);
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw =  new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(name+","+lane+","+kills+","+deaths+","+assists);
            pw.flush();
            pw.close();
            clearInputs();
        } catch(NumberFormatException e) {
            errorLabel.setText("Insert Only Number In Kills/Deaths/Assists!");
            clearInputs();
        } catch (IOException e) {
            errorLabel.setText("Error happens");
        }
    }

    @FXML
    private void clearInputs() {
        nameTextField.setText("");
        laneTextField.setText("");
        killsTextField.setText("");
        deathsTextField.setText("");
        assistsTextField.setText("");
    }

}


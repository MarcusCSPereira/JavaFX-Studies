package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller02 {

    @FXML
    private Label label;

    public void displayName(String username) {
        label.setText("Hello " + username);
    }

    private SceneController sceneController = new SceneController();

    public void switchScene1(ActionEvent event) throws IOException {
        sceneController.switchScene(event, "/view/aula05_tela01.fxml", "/css/aula05.css");
    }
}

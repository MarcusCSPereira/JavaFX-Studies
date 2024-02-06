package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller01 {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField text_field;

    @FXML
    Button loginButton;

    private SceneController sceneController = new SceneController();

    public void login(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/aula05_tela02.fxml"));
        root = loader.load();
        
        Controller02 controller02 = loader.getController();
        String username = text_field.getText();
        controller02.displayName(username);

        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/css/aula05.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        }

    public void switchScene2(ActionEvent event) throws IOException {
        sceneController.switchScene(event, "/view/aula05_tela02.fxml", "/css/aula05.css");
    }


}
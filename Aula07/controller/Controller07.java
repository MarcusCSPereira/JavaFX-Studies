package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller07 {
    @FXML
    private Button logoutButton;
    
    @FXML
    private AnchorPane pane;

    Stage stage;

    public void logout(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Você deseja mesmo sair?");
        alert.setContentText("Clique em OK para confirmar ou em Cancelar para voltar.");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
        }
    }

    
}

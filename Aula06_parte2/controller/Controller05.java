package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller05 implements Initializable{

    @FXML private TextField agetf3, emailtf3, nametf3;

    private Stage stage;

    @FXML
    void threeSendOne(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela03.fxml"));
        Parent root = loader.load();
        Controller03 controller03 = loader.getController();
        controller03.showInformation(nametf3.getText(), emailtf3.getText(), agetf3.getText());
        openNewStage(root, "Tela 01");
        
    }

    @FXML
    void threeSendTwo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela04.fxml"));
        Parent root = loader.load();
        Controller04 controller04 = loader.getController();
        controller04.showInformation(nametf3.getText(), emailtf3.getText(), agetf3.getText());
        openNewStage(root, "Tela 02");
    }

    private void openNewStage(Parent root, String title) {
        if (stage != null) {
            stage.close(); // Fecha a instância anterior
        }
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }


    public void showInformation(String name, String email, String age) {
        nametf3.setText(name);
        emailtf3.setText(email);
        agetf3.setText(age);
    }
    public void closeStage() {
        Stage stage = (Stage) nametf3.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {}


}

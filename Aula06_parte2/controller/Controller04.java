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

public class Controller04 implements Initializable{

    @FXML private TextField agetf2, emailtf2, nametf2;

    private Stage stage;

    @FXML
    void twoSendOne(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela03.fxml"));
        Parent root = loader.load();
        Controller03 controller03 = loader.getController();
        controller03.showInformation(nametf2.getText(), emailtf2.getText(), agetf2.getText());
        openNewStage(root, "Tela 01");
    }

    @FXML
    void twoSendThree(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela05.fxml"));
        Parent root = loader.load();
        Controller05 controller05 = loader.getController();
        controller05.showInformation(nametf2.getText(), emailtf2.getText(), agetf2.getText());
        openNewStage(root, "Tela 03");
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
        nametf2.setText(name);
        emailtf2.setText(email);
        agetf2.setText(age);
    }

    public void closeStage() {
        Stage stage = (Stage) nametf2.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

}

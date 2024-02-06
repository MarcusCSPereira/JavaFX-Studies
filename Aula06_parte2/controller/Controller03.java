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

public class Controller03 implements Initializable {

    @FXML private TextField agetf1, emailtf1, nametf1;

    private Stage stage;

    @FXML
    void oneSendThree(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela05.fxml"));
        Parent root = loader.load();
        Controller05 controller05 = loader.getController();
        controller05.showInformation(nametf1.getText(), emailtf1.getText(), agetf1.getText());
        openNewStage(root, "Tela 03");
    }

    @FXML
    void oneSendTwo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela04.fxml"));
        Parent root = loader.load();
        Controller04 controller04 = loader.getController();
        controller04.showInformation(nametf1.getText(), emailtf1.getText(), agetf1.getText());
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
        nametf1.setText(name);
        emailtf1.setText(email);
        agetf1.setText(age);
    }

    public void closeStage() {
        Stage stage = (Stage) nametf1.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}


}

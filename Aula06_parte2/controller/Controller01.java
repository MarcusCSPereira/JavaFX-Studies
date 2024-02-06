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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Data;

public class Controller01 implements Initializable{
    
    Stage stage;
    Parent root;
    
    @FXML
    TextField textfield;
    @FXML
    ColorPicker color;
    
    Data data = Data.getInstance();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (data.getText() != null) {
            textfield.setText(data.getText());
        }
        if (data.getColor() != null) {
            color.setValue(data.getColor());
        }
    }

    public void submit(ActionEvent event) throws IOException {

        data.setText(textfield.getText());
        data.setColor(color.getValue());

        stage = (Stage) textfield.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/tela02.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Tela 02");
        
    }

}

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;
import model.Data;

public class Controller02 implements Initializable {

    Stage stage;
    Parent root;

    @FXML
    TextArea text;
    @FXML
    AnchorPane pane;

    Data data = Data.getInstance();
    
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            text.setText(data.getText());
            pane.setBackground(new Background(new BackgroundFill(data.getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        }

    public void back(ActionEvent event) throws IOException {

        stage = (Stage) text.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("../view/tela01.fxml"));
        stage.setTitle("Tela 01");
        stage.setScene(new Scene(root));
        
    }

}

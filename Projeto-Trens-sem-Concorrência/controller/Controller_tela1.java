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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.DataTransfer;
import javafx.scene.Node;

public class Controller_tela1 implements Initializable {
    
    @FXML
    private ChoiceBox<String> choicebox;

    DataTransfer dataTransfer = DataTransfer.getInstance();

    @FXML
    public void start(ActionEvent event) throws IOException{

        dataTransfer.setChoice(choicebox.getSelectionModel().getSelectedIndex()
        );

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tela2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

    String[] options = {"Superior esquerdo / Superior direito", "Inferior esquerdo / Inferior direito", "Superior esquedo / Inferior direito", "Inferior esquerdo / Superior direito"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicebox.getItems().addAll(options);
        choicebox.setValue(options[dataTransfer.getChoice()]);
    }



}

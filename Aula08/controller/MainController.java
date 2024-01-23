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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController implements Initializable{

    @FXML
    private Button button;
    @FXML
    private ChoiceBox<String> choicebox;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String[] nodes = {"Image View","TextField","CheckBox","RadioButton","DatePicker","ColorPicker","ChoiceBox","Sliders","ProgressBar","Spinner"};


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicebox.getItems().addAll(nodes);
    }

    public void join(ActionEvent event) throws IOException {
        String node = choicebox.getValue();
        switch (node) {
            case "Image View":
                switchScreen("/view/tela01_aula08.fxml", event, "/css/tela1_aula08.css");
                break;
            case "TextField":
                switchScreen("/view/tela02_aula08.fxml", event, null);
                break;
            case "CheckBox":
                switchScreen("/view/tela03_aula08.fxml", event,null);
                break;
            case "RadioButton":
                switchScreen("/view/tela04_aula08.fxml", event,null);
                break;
            case "DatePicker":
                switchScreen("/view/tela05_aula08.fxml", event,null);
                break;
            case "ColorPicker":
                switchScreen("/view/tela06_aula08.fxml", event,null);
                break;
            case "ChoiceBox":
                switchScreen("/view/tela07_aula08.fxml", event,null);
                break;
            case "Sliders":
                switchScreen("/view/tela08_aula08.fxml", event,null);
                break;
            case "ProgressBar":
                switchScreen("/view/tela09_aula08.fxml", event,null);
                break;
            case "Spinner":
                switchScreen("/view/tela10_aula08.fxml", event,null);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public void switchScreen(String fxml,ActionEvent e, String css) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource(fxml));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        if (css != null) {
            scene.getStylesheets().add(this.getClass().getResource(css).toExternalForm());
        }

        stage.setScene(scene);
        stage.show();
    }
    
}

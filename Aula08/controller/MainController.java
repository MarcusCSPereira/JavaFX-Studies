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

private String[] nodes = {"ImageView","TextField","CheckBox","RadioButton","DatePicker","ColorPicker","ChoiceBox","Sliders","ProgressBar","Spinner","ListView","TreeView","TableView", "MenuBar","FlowPane","GridPane","TabPane","ToolBar | BorderPane","KeyEvents","MediaView","WebView","MusicPlayer"};

/* 
Outros Panes para ver depois:
"StackPane","DialogPane","ScrollPane","SplitPane","TilePane","TitledPane"
*/


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicebox.getItems().addAll(nodes);
    }

    public void join(ActionEvent event) throws IOException {
        String node = choicebox.getValue();
        switch (node) {
            case "ImageView":
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
            case "ListView":
                switchScreen("/view/tela11_aula08.fxml", event,null);
                break;
            case "TreeView":
                switchScreen("/view/tela12_aula08.fxml", event,null);
                break;
            case "TableView":
                switchScreen("/view/tela13_aula08.fxml", event,null);
                break;
            case "MenuBar":
                switchScreen("/view/tela14_aula08.fxml", event,null);
                break;
            case "FlowPane":
                switchScreen("/view/tela15_aula08.fxml", event,null);
                break;
            case "GridPane":
                switchScreen("/view/tela16_aula08.fxml", event,null);
                break;
            case "TabPane":
                switchScreen("/view/tela17_aula08.fxml", event,null);
                break;
            case "ToolBar | BorderPane":
                switchScreen("/view/tela18_aula08.fxml", event,null);
                break;
            case "KeyEvents":
                switchScreen("/view/tela19_aula08.fxml", event,null);
                break;
            case "MediaView":
                switchScreen("/view/tela20_aula08.fxml", event,null);
                break;
            case "WebView":
                switchScreen("/view/tela21_aula08.fxml", event,null);
            case "MusicPlayer":
                switchScreen("/view/tela22_aula08.fxml", event,null);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public void switchScreen(String fxml,ActionEvent e, String css) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        root = loader.load();
        
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        if (css != null) {
            scene.getStylesheets().add(this.getClass().getResource(css).toExternalForm());
        }

        stage.setScene(scene);
        stage.show();
    }
    
}


package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchScene(ActionEvent e, String fxmlPath, String cssPath) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);

        if (cssPath != null && !cssPath.isEmpty()) {
            scene.getStylesheets().add(this.getClass().getResource(cssPath).toExternalForm());
        }

        stage.setScene(scene);
        stage.show();
    }
}
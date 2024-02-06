import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("./view/tela03.fxml"));

        //Se você deseja ver o método por DataSingleton:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("./view/tela01.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        //scene.getStylesheets().add(getClass().getResource("./css/tela01.css").toExternalForm());

        Image icon = new Image(getClass().getResourceAsStream("./assets/icon.jpg"));

        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tela 01");
        primaryStage.show();

      
    }

    public static void main(String[] args) {
        launch(args);
    }
}

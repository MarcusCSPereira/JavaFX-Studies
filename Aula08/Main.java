import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("./view/telaMain_aula08.fxml"));

        Scene scene = new Scene(root);

        /*
        String css = this.getClass().getResource("./css/tela1_aula08.css").toExternalForm();
        scene.getStylesheets().add(css);
        */
        
        Image icon = new Image(getClass().getResourceAsStream("./assets/icon1.png"));

        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Aula 08");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
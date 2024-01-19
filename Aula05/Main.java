import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("./view/main.fxml"));

        // Cria a cena
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("./css/main.css").toExternalForm());
        String css = this.getClass().getResource("./css/main.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Configura o palco (stage)
        primaryStage.setTitle("Aula-05 Estilização com css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

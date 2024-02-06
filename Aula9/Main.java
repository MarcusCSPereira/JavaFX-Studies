import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela01_aula11.fxml"));
        Parent root = loader.load();

        // Cria a cena
        Scene scene = new Scene(root);

        // Configura o palco principal
        primaryStage.setTitle("Tela 01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
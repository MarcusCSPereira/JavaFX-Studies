import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML com as ideias de animações básicas:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("./view/tela01_aula09.fxml"));

        // Carrega o arquivo FXML com uma animação básica de TimeLine, para entender o seu funcionamento em quesito de tempo e execução de KeyFrame:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./view/tela02_aula09.fxml"));
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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Passando a tela para o root
        Parent root = FXMLLoader.load(getClass().getResource("./view/aula05_tela01.fxml"));

        Scene scene = new Scene(root);

        Image icon = new Image(getClass().getResourceAsStream("./assets/icon1.png"));

        //Adicionando CSS
        String css = this.getClass().getResource("./css/aula05.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aula 06 - JavaFX");
        primaryStage.show();
    }
    
}
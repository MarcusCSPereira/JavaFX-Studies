import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("./view/tela1.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        Image icon = new Image(getClass().getResourceAsStream("./assets/trem_icon.png"));
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Train Simulator");
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
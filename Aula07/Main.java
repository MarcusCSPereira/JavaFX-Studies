
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("./view/tela_aula07.fxml"));

        Image icon = new Image(getClass().getResourceAsStream("./assets/icon1.png"));
        
        Scene scene = new Scene(root);

        String css = this.getClass().getResource("./css/aula07.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            logout(primaryStage);
        });
        
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Aula 07 - JavaFX");
        primaryStage.show();
    }


    public void logout(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Você deseja mesmo sair?");
        alert.setContentText("Clique em OK para confirmar ou em Cancelar para voltar.");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
}

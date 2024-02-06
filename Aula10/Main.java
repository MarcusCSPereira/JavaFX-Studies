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
        //Caso eu queira ver como funciona a criptografia AES, basta descomentar a linha abaixo:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela01.fxml"));

        //Caso eu queira ver um programa de login que usa esse EncryptorAES, basta descomentar a linha abaixo:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela02.fxml"));

        //Caso eu queira ver um programa que posso escolher entre dois tipos de criptografia para ver o funcionamento (AES || TripleDES), basta descomentar a linha abaixo:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela03.fxml"));

        //Caso eu queira ver um programa de login que utiliza um Encyptor de MD5 Hash, basta descomentar a linha abaixo:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela04.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));

        primaryStage.setTitle("AES Encryptor/Decryptor");
        primaryStage.show();

    }
}
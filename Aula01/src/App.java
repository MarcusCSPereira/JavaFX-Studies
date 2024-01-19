import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Stage stage = new Stage();
        Group root = new Group();// Criando o root
        Scene scene = new Scene(root,Color.BLUEVIOLET);// Criando a Scene e passando para ela o root
        Image icon = new Image("assets/teste.png");

        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Teste do Cesinha");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        //primaryStage.setX(0);
        //primaryStage.setY(0);
        //primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("Você pode sair da tela cheia apertando Q");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

        primaryStage.setScene(scene);//Colocando e ligando a Scene ao Stage
        primaryStage.show();//Demostrando o Stage na tela.
    }
}

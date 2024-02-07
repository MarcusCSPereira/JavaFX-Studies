import PingPongGame.PongGame;
import TetrisGame.Tetris;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML do SnakeGame:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela01_aula11.fxml"));

        // Carrega o arquivo FXML do MemoryGame:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela02_aula11.fxml"));

        //Carrega o arquivo FXML do Genius:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela03_aula11.fxml"));

        //Carrega o arquivo FXML sobre a forma de fazer DraggableNodes:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela04_01_aula11.fxml"));
        
        //Carrega o arquivo FXML sobre a forma de trabalhar com Multiple Keyboard inputs,delimitando o movimento do node apenas dentro da tela e colisões entre nodes:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela04_02_aula11.fxml"));

        //Carrega o arquivo FXML sobre a forma de trabalhar com o Draggable com travamentos em grid:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela04_03_aula11.fxml"));

        //Carrega o arquivo FXML sobre a forma de trabalhar como trabalhar com bounce em nodes:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela04_04_aula11.fxml"));

        //Carrega o arquivo FXML sobre o Dogde Game, que envolve a movimentação de um node para desviar de obstáculos:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela05_aula11.fxml"));

        //Carrega o arquivo FXML sobre o Brick breaker game, que envolve a movimentação de um node Draggable, com a adição de um bounce Movemnte para jogar o jogo:
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela06_aula11.fxml"));

        //Carrega o arquivo FXML sobre o Flappy Bird game, que envolve a movimentação de um node para desviar de obstáculos, com o ColisionDetection e a criação de Obstacles em classes model separadas:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/tela07_aula11.fxml"));
        Parent root = loader.load();
        // Cria a cena
        Scene scene = new Scene(root);

        // Configura o palco principal
        primaryStage.setScene(scene);
        primaryStage.setTitle("Games");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //Chama o TetrisGame:
        //Tetris.main(args);
        //Chama o PingPongGame:
        //PongGame.main(args);
    }
}
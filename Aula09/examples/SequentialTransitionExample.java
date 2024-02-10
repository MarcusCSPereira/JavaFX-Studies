package examples;

import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SequentialTransitionExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criar um círculo
        Circle circle = new Circle(50, Color.BLUE);
        circle.setCenterX(50);
        circle.setCenterY(100);

        // Criar uma transição de movimento para a direita
        TranslateTransition moveRight = new TranslateTransition(Duration.seconds(2), circle);
        moveRight.setByX(200);

        // Criar uma transição de mudança de cor para vermelho
        FillTransition changeColor1 = new FillTransition(Duration.seconds(1), circle, Color.BLUEVIOLET, Color.RED);

        FillTransition changeColor2 = new FillTransition(Duration.seconds(1), circle, Color.RED, Color.BLUEVIOLET);

        // Criar uma transição de movimento para a esquerda
        TranslateTransition moveLeft = new TranslateTransition(Duration.seconds(2), circle);
        moveLeft.setByX(-200);

        // Criar uma transição sequencial que combina as três transições
        SequentialTransition sequentialTransition = new SequentialTransition(moveRight, changeColor1, moveLeft, changeColor2);
        sequentialTransition.setCycleCount(SequentialTransition.INDEFINITE);
        sequentialTransition.setDelay(Duration.millis(500));
        
        // Configurar o palco
        StackPane root = new StackPane();
        root.getChildren().add(circle);
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sequential Transition Example");
        primaryStage.show();

        // Iniciar a transição sequencial
        sequentialTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

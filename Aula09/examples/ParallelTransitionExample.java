package examples;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ParallelTransitionExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criar um retângulo
        Rectangle rectangle = new Rectangle(0, 100, 100, 50);
        rectangle.setFill(Color.BLUE);

        // Criar uma transição de movimento horizontal
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), rectangle);
        translateTransition.setByX(200);

        // Criar uma transição de mudança de cor
        FillTransition fillTransition = new FillTransition(Duration.seconds(3), rectangle);
        fillTransition.setFromValue(Color.BLUE);
        fillTransition.setToValue(Color.RED);

        // Criar uma transição paralela que combina as duas transições
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(translateTransition, fillTransition);
        parallelTransition.setCycleCount(ParallelTransition.INDEFINITE);
        parallelTransition.setAutoReverse(true);
        
        // Configurar o palco
        StackPane root = new StackPane();
        root.getChildren().add(rectangle);
        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Parallel Transition Example");
        primaryStage.show();

        // Iniciar a transição paralela
        parallelTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

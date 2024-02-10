package examples;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineWithKeyFramesExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criar um círculo
        Circle circle = new Circle(50, Color.BLUE);
        circle.setCenterX(50);
        circle.setCenterY(100);

        // Criar uma linha do tempo (Timeline)
        Timeline timeline = new Timeline();

        // Adicionar vários KeyFrames à linha do tempo
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, e -> { // KeyFrame inicial
                    circle.setFill(Color.BLUE);
                    circle.setTranslateX(0);
                    System.out.println("KeyFrame inicial");
                }),
                new KeyFrame(Duration.seconds(1), e -> { // KeyFrame após 1 segundo
                    circle.setFill(Color.RED);
                    circle.setTranslateX(100);
                }),
                new KeyFrame(Duration.seconds(2), e -> { // KeyFrame após 2 segundos
                    circle.setFill(Color.GREEN);
                    circle.setTranslateX(200);
                }),
                new KeyFrame(Duration.seconds(3), e -> { // KeyFrame após 3 segundos
                    circle.setFill(Color.YELLOW);
                    circle.setTranslateX(300);
                })
        );
        
        // Configurar o palco
        StackPane root = new StackPane();
        root.getChildren().add(circle);
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Timeline with KeyFrames Example");
        primaryStage.show();

        // Iniciar a linha do tempo
        timeline.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

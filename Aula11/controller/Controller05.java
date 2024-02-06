package controller;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.MovementController;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller05 implements Initializable {

    @FXML
    private Rectangle shape1;

    @FXML
    private AnchorPane scene;

    private Random random = new Random();

    private TranslateTransition transition;

    private ArrayList<Rectangle> dangerousRectangles = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MovementController movementController = new MovementController(shape1, scene);

        timeline.setCycleCount(Animation.INDEFINITE);

        collisionTimer.start();
    }

    @FXML
    void start(ActionEvent event) {
        if(timeline.getStatus() == Animation.Status.RUNNING){
            timeline.stop();
        } else {
            timeline.play();
        }
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e ->{
        Rectangle rectangle = createDangerShape();
        scene.getChildren().add(rectangle);
        dangerousRectangles.add(rectangle);
        transition.play();
    }));


    AnimationTimer collisionTimer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {

            for (Rectangle rectangle: dangerousRectangles) {
                if(rectangle != null){
                    checkCollision(shape1,rectangle);
                }
            }
        }
    };


    public void checkCollision(Rectangle shape1, Rectangle collisionShape){

        if(shape1.getBoundsInParent().intersects(collisionShape.getBoundsInParent())){
            timeline.stop();
            System.out.println("Game over!");
        }
    }

    public Rectangle createDangerShape(){
        int recHeightX = random.nextInt(250);

        int recHeight = 25 + random.nextInt(100);
        int recWidth = 25 + random.nextInt(100);

        Rectangle rectangle = new Rectangle(700,recHeightX,recHeight,recWidth);

        rectangle.setFill(Color.RED);

        transition = new TranslateTransition();

        transition.setNode(rectangle);
        transition.setDuration(Duration.seconds(5));
        transition.setToX(-900);
        transition.setOnFinished(e ->{
            scene.getChildren().remove(rectangle);
            dangerousRectangles.remove(rectangle);
        });
        return rectangle;
    }
}
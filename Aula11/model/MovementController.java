package model;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class MovementController {

    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed);

    private int movementVariable = 2;

    @FXML
    private Rectangle shape1;

    @FXML
    private AnchorPane scene;

    private double shape1size;

    public MovementController(Rectangle shape1, AnchorPane scene) {
        this.shape1 = shape1;
        this.scene = scene;

        movementSetup();
        shape1size = shape1.getHeight();

        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                timer.start();
            } else {
                timer.stop();
            }
        }));
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {

            if(wPressed.get()) {
                shape1.setLayoutY(shape1.getLayoutY() - movementVariable);
            }

            if(sPressed.get()){
                shape1.setLayoutY(shape1.getLayoutY() + movementVariable);
            }

            if(aPressed.get()){
                shape1.setLayoutX(shape1.getLayoutX() - movementVariable);
            }

            if(dPressed.get()){
                shape1.setLayoutX(shape1.getLayoutX() + movementVariable);
            }

            squareAtBorder();
        }

        private void squareAtBorder() {
            double leftBorder = 0;
            double topBorder = 0;
            double rightBorder = scene.getWidth() - shape1size;
            double bottomBorder = scene.getHeight() - shape1size;
            
            if (shape1.getLayoutX() <= leftBorder) {
                shape1.setLayoutX(leftBorder);
            }
            if (shape1.getLayoutX() >= rightBorder) {
                shape1.setLayoutX(rightBorder);
            }
            if (shape1.getLayoutY() <= topBorder) {
                shape1.setLayoutY(topBorder);
            }
            if (shape1.getLayoutY() >= bottomBorder) {
                shape1.setLayoutY(bottomBorder);
            }
        }
    };

    public void movementSetup(){
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.W) {
                wPressed.set(true);
            }

            if(e.getCode() == KeyCode.A) {
                aPressed.set(true);
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(true);
            }

            if(e.getCode() == KeyCode.D) {
                dPressed.set(true);
            }
        });

        scene.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.W) {
                wPressed.set(false);
            }

            if(e.getCode() == KeyCode.A) {
                aPressed.set(false);
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(false);
            }

            if(e.getCode() == KeyCode.D) {
                dPressed.set(false);
            }
        });
    }
}
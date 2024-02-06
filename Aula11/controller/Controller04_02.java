package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import model.MovementController;

public class Controller04_02 implements Initializable {

    
    @FXML
    private Rectangle shapeDanger;
    
    @FXML
    private Rectangle shape1;
    
    @FXML
    private AnchorPane scene;

    @FXML
    void start(ActionEvent event) {
        shape1.setLayoutY(200);
        shape1.setLayoutX(280);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MovementController movementController = new MovementController(shape1, scene);
        colisionTimer.start();
    }

    AnimationTimer colisionTimer = new  AnimationTimer() {
        @Override
        public void handle(long l) {
            checkColision(shape1, shapeDanger);
        }
    };

    private void checkColision(Rectangle shape1, Rectangle shapeDanger) {
        if(shape1.getBoundsInParent().intersects(shapeDanger.getBoundsInParent())){
            System.out.println("Colision");
        }
    }

}


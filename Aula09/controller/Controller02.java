package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Controller02 implements Initializable{

    @FXML
    private Label label;

    int i = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(String.valueOf(i));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            i++;
            label.setText(String.valueOf(i));
            if (i == 10) {
                System.out.println("Alarme");
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
}

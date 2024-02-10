package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Controller01 implements Initializable{

    @FXML private ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*Translate:
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(image);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(200);
        translate.setByY(-150);
        translate.setDelay(Duration.millis(1000));
        translate.setAutoReverse(true);
        translate.play();*/

        // Rotate:
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(image);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setByAngle(360);
        rotate.setInterpolator(Interpolator.LINEAR);
        //rotate.setDelay(Duration.millis(1000));
        //rotate.setAutoReverse(true);
        rotate.setAxis(Rotate.Z_AXIS);//Podendo ser X/Y/Z
        rotate.play();

        // Fade:
        /*FadeTransition fade = new FadeTransition();
        fade.setNode(image);
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);//Para fade in use 0, fade out use 1
        fade.setToValue(1);//Para fade in use 1, fade out use 0
        fade.play();*/

        // Scale:
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(image);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(ScaleTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setAutoReverse(true);
        scale.setByX(1.3);//Para diminuir use 0.5
        scale.setByY(1.3);//Para diminuir use 0.5
        scale.play();
    }
    
}

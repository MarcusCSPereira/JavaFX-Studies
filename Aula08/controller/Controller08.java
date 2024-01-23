package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller08 implements Initializable{
    
    @FXML 
    private Label label;
    @FXML
    private ImageView imageview;
    @FXML
    private Slider slider;

    Image normal = new Image(getClass().getResourceAsStream("/assets/normal.jpeg"));
    Image calor = new Image(getClass().getResourceAsStream("/assets/calor.jpg"));
    Image frio = new Image(getClass().getResourceAsStream("/assets/frio.jpeg"));

    int temperatura;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        slider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                temperatura = (int) slider.getValue();
                label.setText(temperatura + "ºC");
                if (temperatura <= 15) {
                    imageview.setImage(frio);
                } else if (temperatura > 15 && temperatura <= 30) {
                    imageview.setImage(normal);
                } else {
                    imageview.setImage(calor);
                }
            }
        });
    }






    
}

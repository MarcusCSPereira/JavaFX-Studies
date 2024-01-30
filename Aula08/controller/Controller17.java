package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller17 implements Initializable{
    
    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;

    private ImageView addGraphics(String url) {

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(url)));
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        
        return imageView;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tab1.setGraphic(addGraphics("/assets/icon1.png"));
        tab2.setGraphic(addGraphics("/assets/shrek1.jpg"));
        tab3.setGraphic(addGraphics("/assets/shrek2.jpg"));
    }

}

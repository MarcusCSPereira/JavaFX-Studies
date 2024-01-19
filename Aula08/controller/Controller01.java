package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller01 {
    
    @FXML
    Button button;
    @FXML
    ImageView imageView;

    Image image1 = new Image(getClass().getResourceAsStream("/assets/shrek1.jpg"));
    Image image2 = new Image(getClass().getResourceAsStream("/assets/shrek2.jpg"));

    public void displayImage(){
        if(imageView.getImage() == image2){
            imageView.setImage(image1);
        }else{
            imageView.setImage(image2);
        }
    }

}

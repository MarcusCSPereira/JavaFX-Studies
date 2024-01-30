package controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller19{
    
    @FXML
    ImageView imageview;
    @FXML
    Label label;

    Image img = new Image(getClass().getResourceAsStream("/assets/seta.png"));
    
    @FXML
    void action(KeyEvent event) {
        label.setVisible(false);
        imageview.setImage(img);

        if(event.getCode().equals(KeyCode.RIGHT)){
            imageview.setRotate(0);
        }
        if(event.getCode().equals(KeyCode.LEFT)){
            imageview.setRotate(180);
        }
        if(event.getCode().equals(KeyCode.UP)){
            imageview.setRotate(270);
        }
        if(event.getCode().equals(KeyCode.DOWN)){
            imageview.setRotate(90);
        }
    }



    

}

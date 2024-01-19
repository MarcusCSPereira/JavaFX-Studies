package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller03 {
    
    @FXML
    ImageView imageview;
    @FXML
    CheckBox checkbox;
    @FXML
    Label label;

    Image lampOn = new Image(getClass().getResourceAsStream("/assets/lightOn.jpg"));
    Image lampOff = new Image(getClass().getResourceAsStream("/assets/lightOff.jpg"));

    public void changeImage(ActionEvent event) {
        if (checkbox.isSelected()) {
            imageview.setImage(lampOn);
            label.setText("ON");
        } else {
            imageview.setImage(lampOff);
            label.setText("OFF");
        }
    }
    

}

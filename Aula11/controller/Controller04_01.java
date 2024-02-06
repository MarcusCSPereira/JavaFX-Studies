package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import model.DraggableMaker;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller04_01 implements Initializable {

    @FXML
    private Rectangle rectangle;

    @FXML
    private AnchorPane anchorPane;


    DraggableMaker draggableMaker = new DraggableMaker();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        draggableMaker.makeDraggable(rectangle);
        draggableMaker.makeDraggable(anchorPane);
    }
}
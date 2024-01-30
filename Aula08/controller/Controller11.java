package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller11 implements Initializable {
    
    @FXML
    Label label;
    @FXML
    ListView<String> listview;

    String[] food = {"Pizza", "Hamburger", "Hot Dog", "Pasta", "Salad", "Soup", "Sandwich",""};

    String currentFood;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listview.getItems().addAll(food);

        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentFood = listview.getSelectionModel().getSelectedItem();
                label.setText("Current value: " + currentFood);
            }

        });
    }



}

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Controller10 implements Initializable{
    
    @FXML
    Spinner<Integer> spinner;
    @FXML 
    Label label;

    int currentValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

        valueFactory.setValue(1);

        spinner.setValueFactory(valueFactory);

        currentValue = spinner.getValue();

        label.setText("Current value: " + currentValue);

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                currentValue = spinner.getValue();
                label.setText("Current value: " + currentValue);
            }

        });

    }

}

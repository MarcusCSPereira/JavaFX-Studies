package controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Controller09 implements Initializable {
   
    @FXML
    Button buttonMais;
    @FXML
    Button buttonMenos;
    @FXML
    Label label;
    @FXML
    ProgressBar progressbar;

   
    BigDecimal progress = new BigDecimal(0);

    public void diminuir() {
        if(progress.doubleValue() > 0){
            progress = progress.subtract(new BigDecimal(0.1));
            progressbar.setProgress(progress.doubleValue());
            label.setText(String.format("%.0f%%", progress.doubleValue() * 100));
        }
    }

    public void aumentar() {
        if(progress.doubleValue() < 1){
            progress = progress.add(new BigDecimal(0.1));
            progressbar.setProgress(progress.doubleValue());
            label.setText(String.format("%.0f%%", progress.doubleValue() * 100));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressbar.setStyle("-fx-accent: red;");
    }

    
}

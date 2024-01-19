package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Controller04 {
    @FXML
    Label label;
    @FXML
    RadioButton vbutton, lbutton, dbutton;

    public void getGame(ActionEvent event){
        if(vbutton.isSelected())
            label.setText(vbutton.getText());
        else if(lbutton.isSelected())
            label.setText(lbutton.getText());
        else if(dbutton.isSelected())
            label.setText(dbutton.getText());
        else
            label.setText("Nenhum jogo selecionado");
    }
}

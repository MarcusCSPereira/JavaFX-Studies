package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class Controller05 {
   
    @FXML
    private Label label;
    @FXML
    private DatePicker datepicker;

    public void getData(ActionEvent event){

        LocalDate date = datepicker.getValue();
        String formatedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));//Posso usar ("dd/MM/yyyy") ou (""dd-MM-yyyy"), caso eu use MMM ele me retorna o nome do mês.
        label.setText(formatedDate);
    }


}

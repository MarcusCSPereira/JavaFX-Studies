package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller02 {
    //Injetando nodes do FXML com id's definidos
    @FXML
    Button button;

    @FXML
    Label label;
    
    @FXML
    TextField textfield;

    //variável necessária para essa lógica de programação.
    int idade;

    public void checkField(ActionEvent event){
        //Pegando o texto do textField e convertendo para inteiro
        try {
            idade = Integer.parseInt(textfield.getText());
            //Verificando se a idade é maior ou igual a 18
            if(idade >= 18){
                label.setText("Maior de idade, entrada permitida");
            }else{
                label.setText("Menor de idade, entrada proibida");
            }
            
        } catch (NumberFormatException e) {
            textfield.setText("");
            textfield.setPromptText("Digite apenas números");
        }

    }

}

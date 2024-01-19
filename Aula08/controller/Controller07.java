package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller07 implements Initializable {
    @FXML
    private Label label;
    @FXML
    private ChoiceBox<String> choicebox;

    private String[] games ={"Valorant", "CS:GO", "League of Legends", "Minecraft", "GTA V", "Fortnite", "Among Us", "FIFA 24", "PUBG", "Free Fire"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicebox.getItems().addAll(games);//popularizando o choicebox
        choicebox.setOnAction(this::getGame);//quando eu selecionar um item do choicebox ele vai chamar o método getGame, por meio dessa linkagem do setOnAction com o método getGame.
    }

    public void getGame(ActionEvent event) {
        String game = choicebox.getValue();
        label.setText(game);
    }


}

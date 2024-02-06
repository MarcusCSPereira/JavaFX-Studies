package controller;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller03 implements Initializable {

    ArrayList<String> possibleButtons = new ArrayList<>(
            Arrays.asList("button0", "button1", "button2", "button3", "button4",
                    "button5", "button6", "button7", "button8"));

    ArrayList<Button> buttons = new ArrayList<>();

    ArrayList<String> pattern = new ArrayList<>();

    int patternOrder = 0;
    boolean isRunning = false;

    Random random = new Random();
    PauseTransition pause;

    int counter = 1;
    int turn = 1;

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Label text, pointlabel;

    @FXML
    private Button startBtt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons.addAll(Arrays.asList(button0, button1, button2, button3, button4,
                button5, button6, button7, button8));
    }

    @FXML
    void start(ActionEvent event) {
        isRunning = true;
        turn = 0;
        pointlabel.setText("Points: " + turn);
        for (Button button : buttons) {
            button.setDisable(false);
            paintButtons(button);
        }
        pattern.clear();
        startBtt.setDisable(true);
        text.setText("");

        pattern.add(possibleButtons.get(random.nextInt(possibleButtons.size())));
        showPattern();

        counter = 0;
        turn = 1;
    }

    @FXML
    void buttonClicked(ActionEvent event) {

        if (((Control) event.getSource()).getId().equals(pattern.get(counter))) {
            
            Button button = buttons.get(getIndexOfButton(event));
            changeButtonColor(button, colorFinder(button));
            counter++;

        } else {
            for (Button button : buttons) {
                changeButtonFixedColor(button, "-fx-base: #FF0000");
                button.setDisable(true);
            }
            text.setText("Wrong, You Lose!");
            isRunning = false;
            startBtt.setDisable(false);
            startBtt.setText("Restart");
        }

        if (counter == turn && isRunning) {
            pointlabel.setText("Points: " + turn);
            nextTurn();
        }
    }

    private void changeButtonColor(Button button, String color) {
        button.setStyle(color);
            pause = new PauseTransition(
                    Duration.seconds(0.5));
            pause.setOnFinished(e -> {
                paintButtons(button);
            });
            pause.play();
    }

    private void changeButtonFixedColor(Button button, String string) {
        button.setStyle(string);
    }

    private void nextTurn() {
        counter = 0;
        turn++;

        pattern.add(possibleButtons.get(random.nextInt(possibleButtons.size())));
        showPattern();
    }

    private void showPattern() {
        pause = new PauseTransition(
                Duration.seconds(0.25));
        pause.setOnFinished(e -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.7), event -> {
                    showNext();
            }));
            timeline.setCycleCount(pattern.size());
            timeline.play();
        });
        pause.play();
    }

    private void showNext() {
        Button button = buttons.get(getIndexOfButton(pattern.get(patternOrder)));

            changeButtonColor(button, colorFinder(button));
            patternOrder++;
    
            if (patternOrder == turn) {
                patternOrder = 0;
            }
    }

    private int getIndexOfButton(ActionEvent event) {
        String buttonId = ((Control) event.getSource()).getId();
        return Integer.parseInt(buttonId.substring(buttonId.length() - 1));
    }

    private int getIndexOfButton(String button) {
        return Integer.parseInt(button.substring(button.length() - 1));
    }

    private void paintButtons(Button button) {
        String colorIndex = button.getId().substring(button.getId().length() - 1);
        switch (colorIndex) {
            case "0":
                button.setStyle("-fx-base: #cfcf00");
                break;
            case "1":
                button.setStyle("-fx-base:  #268600");
                break;
            case "2":
                button.setStyle("-fx-base:  #3c0074");
                break;
            case "3":
                button.setStyle("-fx-base:  #005485");
                break;
            case "4":
                button.setStyle("-fx-base:  #a00080");
                break;
            case "5":
                button.setStyle("-fx-base:  #02006c");
                break;
            case "6":
                button.setStyle("-fx-base:  #663300");
                break;
            case "7":
                button.setStyle("-fx-base:  #600000");
                break;
            case "8":
                button.setStyle("-fx-base:  #006e49");
                break;
            default:
                break;
        }
    }


    private String colorFinder(Button button) {
        String colorIndex = button.getId().substring(button.getId().length() - 1);

        switch (colorIndex) {
            case "0":
                return "-fx-base: #FFFF00";
            case "1":
                return "-fx-base: #48FF00";
            case "2":
                return "-fx-base: #8400FF";
            case "3":
                return "-fx-base: #00a2ff";
            case "4":
                return "-fx-base: #ff00cc";
            case "5":
                return "-fx-base: #0000FF";
            case "6":
                return "-fx-base: #ff7f00";
            case "7":
                return "-fx-base: #ff0000";
            case "8":
                return "-fx-base: #00ffaa";
            default:
                return null;

        }
    }

}
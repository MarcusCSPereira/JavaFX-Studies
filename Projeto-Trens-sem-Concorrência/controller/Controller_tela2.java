package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.DataTransfer;
import model.Train;
import model.TrainMovementController;

public class Controller_tela2 implements Initializable {

    Parent root;
    Scene scene;
    Stage stage;

    @FXML
    private Slider slider_trem1, slider_trem2;

    @FXML
    ImageView train1_image, train2_image, resetImage;

    @FXML
    Circle criticalzone1, criticalzone2;

    private Train trem1, trem2;

    // Variáveis para controle de colisão:
    private boolean trem1EnteredFirstCriticalZone1 = false;
    private boolean trem2EnteredFirtsCriticalZone1 = false;
    private boolean trem1EnteredFirstCriticalzone2 = false;
    private boolean trem2EnteredFirtsCriticalzone2 = false;
    private boolean noColision1 = true;
    private boolean noColision2 = true;

    // Classe que controla o movimento dos trens e que checa a colisão com as zonas críticas.
    private TrainMovementController trainMovementController;

    private double movement_variable = 0.5;

    DataTransfer dataTransfer = DataTransfer.getInstance();

    AnimationTimer timer_train1 = new AnimationTimer() {
        @Override
        public void handle(long now) {
            Platform.runLater(() -> {
                trem1.setSpeed(slider_trem1.getValue() * movement_variable);
                trainMovementController.moveTrain(trem1);
            });

        }

    };

    AnimationTimer timer_train2 = new AnimationTimer() {
        @Override
        public void handle(long now) {
            Platform.runLater(() -> {
                trem2.setSpeed(slider_trem2.getValue() * movement_variable);
                trainMovementController.moveTrain(trem2);
            });
        }

    };

    AnimationTimer colisionTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            Platform.runLater(() -> {
                colisionControl();
            });
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        trainMovementController = new TrainMovementController();

        switch (dataTransfer.getChoice()) {
            case 0:
                trem1 = new Train(train1_image, 0);
                trem2 = new Train(train2_image, 1);
                break;
            case 1:
                trem1 = new Train(train1_image, 2);
                trem2 = new Train(train2_image, 3);
                break;
            case 2:
                trem1 = new Train(train1_image, 0);
                trem2 = new Train(train2_image, 3);
                break;
            case 3:
                trem1 = new Train(train1_image, 2);
                trem2 = new Train(train2_image, 1);
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Um error has occurred. Please, try again.");
                alert.showAndWait();
                System.exit(0);
                break;
        }

        slider_trem1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                trem1.setSpeed(slider_trem1.getValue() * movement_variable);
            }

        });

        slider_trem2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                trem2.setSpeed(slider_trem2.getValue() * movement_variable);
            }

        });

        colisionTimer.start();
    }

    @FXML
    public void reset(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tela1.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) resetImage.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void colisionControl(){

        boolean trem1InCriticalZone1 = trainMovementController.checkColision(trem1, criticalzone1);
        boolean trem2InCriticalZone1 = trainMovementController.checkColision(trem2, criticalzone1);

        boolean trem1InCriticalZone2 = trainMovementController.checkColision(trem1, criticalzone2);
        boolean trem2InCriticalZone2 = trainMovementController.checkColision(trem2, criticalzone2);

        if (trem1InCriticalZone1 && trem2InCriticalZone1) {
            // Ambos os trens estão na zona crítica 1

            if (trem1EnteredFirstCriticalZone1 && !trem2EnteredFirtsCriticalZone1) {
                timer_train2.stop(); // Trem 2 deve parar
            } else if (!trem1EnteredFirstCriticalZone1 && trem2EnteredFirtsCriticalZone1) {
                timer_train1.stop(); // Trem 1 deve parar
            }

            noColision1 = false; // Há risco de colisão pois ambos os trens estão na zona crítica 1
             
        } else {

            if (trem1InCriticalZone1) { // Trem 1 está na zona crítica 1
                trem1EnteredFirstCriticalZone1 = true; // Trem 1 entrou primeiro na zona crítica 1
                trem2InCriticalZone1 = false; // Trem 2 não está na zona crítica 1 portanto voltou a false. 
            } else {
                trem1EnteredFirstCriticalZone1 = false; // Trem 1 não está na zona crítica 1, portanto voltou a false.
            }

            if (trem2InCriticalZone1) { // Trem 2 está na zona crítica 1
                trem2EnteredFirtsCriticalZone1 = true; // Trem 2 entrou primeiro na zona crítica 1
                trem1InCriticalZone1 = false; // Trem 1 não está na zona crítica 1 portanto voltou a false.
            } else {
                trem2EnteredFirtsCriticalZone1 = false; // Trem 2 não está na zona crítica 1, portanto voltou a false.
            }

            noColision1 = true; // Não há risco de colisão pois ambos os trens não estão na zona crítica 1

        }

        if (trem1InCriticalZone2 && trem2InCriticalZone2) {
            // Ambos os trens estão na zona crítica 2

            if (trem1EnteredFirstCriticalzone2 && !trem2EnteredFirtsCriticalzone2) {
                timer_train2.stop(); // Trem 2 deve parar
            } else if (!trem1EnteredFirstCriticalzone2 && trem2EnteredFirtsCriticalzone2) {
                timer_train1.stop(); // Trem 1 deve parar
            }

            noColision2 = false; // Há risco de colisão pois ambos os trens estão na zona crítica 2

        } else {
            if (trem1InCriticalZone2) {// Trem 1 está na zona crítica 2
                trem1EnteredFirstCriticalzone2 = true; // Trem 1 entrou primeiro na zona crítica 2
                trem2InCriticalZone2 = false; // Trem 2 não está na zona crítica 2 portanto voltou a false.
            } else {
                trem1EnteredFirstCriticalzone2 = false; // Trem 1 não está na zona crítica 2 mais, portanto voltou a false.
            }
            if (trem2InCriticalZone2) { // Trem 2 está na zona crítica 2
                trem2EnteredFirtsCriticalzone2 = true; // Trem 2 entrou primeiro na zona crítica 2
                trem1InCriticalZone2 = false; // Trem 1 não está na zona crítica 2 portanto voltou a false.
            } else {
                trem2EnteredFirtsCriticalzone2 = false; // Trem 2 não está na zona crítica 2, portanto voltou a false.
            }

            noColision2 = true; // Não há risco de colisão pois ambos os trens não estão na zona crítica 2

        }

        if (noColision1 && noColision2) {
            //Caso não haja risco de colisão, os trens devem voltar a se mover.
            timer_train1.start();
            timer_train2.start();
        }
    }

}

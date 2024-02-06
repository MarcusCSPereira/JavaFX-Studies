package controller;

import java.net.URL;
import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Controller22 implements Initializable {
    
    @FXML
    AnchorPane pane;
    @FXML
    Label label;
    @FXML
    Button playBtt, pauseBtt, resetBtt, previewBtt, nextBtt;
    @FXML
    ProgressBar progressBar;
    @FXML
    ComboBox<String> comboBox;
    @FXML
    Slider slider;
    //Declarando o media player.
    private Media media;
    private MediaPlayer mediaPlayer;

    //Basicamente a organização das músicas.
    private File directory;
    private File[] files;
    private ArrayList<File> songs;
    private int songNumber=0;
    //Controle de tempo da música.
    private Timer timer;
    private TimerTask task;
    private boolean isPlaying;
    //Controle de velocidade da música.
    private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        songs = new ArrayList<File>();
        directory = new File("./assets/music");
        files = directory.listFiles();
        if (files!= null) {
            for (File file : files) {
                songs.add(file);
                //System.out.println(file);
            }
        }

        //Inicializando o media player com a música 1.
        media= new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        label.setText(songs.get(songNumber).getName());

        //Inicializando o choice box.
        for (int i = 0; i < speeds.length; i++) {
            comboBox.getItems().add(speeds[i]+"%");
        }
        comboBox.setOnAction(this::speed);

        //Inicializando o slider.
        slider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(slider.getValue() * 0.01);
            }
            
        });

        //Mudando cor da ProgressBar.
        progressBar.setStyle("-fx-accent: #00ff00;");


    }
    
    public void play() {
        beginTimer();
        mediaPlayer.play();
    }

    public void pause() {
        endTimer();
        mediaPlayer.pause();
    }

    public void reset() {
        progressBar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0.0));
    }

    public void preview() {
        if (songNumber > 0) {
            songNumber--;
            mediaPlayer.stop();

            if(isPlaying){
                endTimer();
            }
            media= new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            label.setText(songs.get(songNumber).getName());
            play();
            speed(null);
        }else{
            songNumber = songs.size()-1;
            mediaPlayer.stop();

            if(isPlaying){
                endTimer();
            }
            media= new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            label.setText(songs.get(songNumber).getName());
            play();
            speed(null);
        }
    }

    public void next() {
        if(songNumber < songs.size()-1) {
            songNumber++;
            mediaPlayer.stop();

            if(isPlaying){
                endTimer();
            }

            media= new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            label.setText(songs.get(songNumber).getName());
            play();
            speed(null);
        }else{
            songNumber = 0;
            mediaPlayer.stop();

            if(isPlaying){
                endTimer();
            }
            media= new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            label.setText(songs.get(songNumber).getName());
            play();
            speed(null);
        }
    }

    public void speed(ActionEvent event) {
        //mediaPlayer.setRate(Integer.parseInt(comboBox.getValue()) * 0.01);
        //Como uso a porcentagem preciso retira-lá aqui, e testar para ver se o valor é nulo, para quando passar de música manter a velocidade.
        if(comboBox.getValue() == null){
            mediaPlayer.setRate(1);
        }else{
            mediaPlayer.setRate(Integer.parseInt(comboBox.getValue().substring(0, comboBox.getValue().length()-1)) * 0.01);
        }
    }

    public void beginTimer() {
        
        timer = new Timer();
        task = new TimerTask() {
        @Override
        public void run() {
            isPlaying = true;
            double current = mediaPlayer.getCurrentTime().toSeconds();
            double end = mediaPlayer.getCycleDuration().toSeconds();

            // Execute o código relacionado à interface do usuário na Thread da Aplicação FX
            Platform.runLater(() -> {
                progressBar.setProgress(current / end);

                if (current / end == 1) {
                    endTimer();
                    next();
                }
            });
        }
    };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void endTimer() {
        isPlaying = false;
        timer.cancel();
    } 


}

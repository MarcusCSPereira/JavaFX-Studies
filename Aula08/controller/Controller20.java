package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Controller20 implements Initializable {
    
    @FXML
    private MediaView mediaView;
    @FXML
    private Button playBtt;
    @FXML
    private Button pauseBtt;
    @FXML
    private Button resetBtt;
    
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    public void play(){
        mediaPlayer.play();
    }

    public void pause(){
        mediaPlayer.pause();
    }

    public void reset(){
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
            mediaPlayer.play();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        file=new File("./assets/naOndinha.mp4");
        media=new Media(file.toURI().toString());
        mediaPlayer=new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }
}

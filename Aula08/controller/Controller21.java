package controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class Controller21 implements Initializable{

    @FXML
    private WebView webView;
    @FXML
    private TextField textField;

    private WebEngine engine;
    private WebHistory history;
    
    private String homePage = "www.google.com.br";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = webView.getEngine();
        textField.setText(homePage);
        loadPage();
    }

    
    public void loadPage() {
        String urlToLoad = "https://" + textField.getText();

        if (testeURL(urlToLoad)) {
            engine.load(urlToLoad);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("URL Inválida");
            alert.setHeaderText("ERRO");
            alert.setContentText("A URL fornecida não é válida.");
            alert.showAndWait();
        }
    }

    private boolean testeURL(String url) {
        try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("HEAD");
            int code = connection.getResponseCode();
            return (code == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            return false;
        }
    }

    public void refreshPage(){
        engine.reload();
    }

    public void zoomIn(){
        webView.setZoom(webView.getZoom() + 0.25);
    }

    public void zoomOut(){
        webView.setZoom(webView.getZoom() - 0.25);
    }

    public void history(){

        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        String historico="";
        for(WebHistory.Entry entry : entries){
            String url = entry.getUrl() + " " + entry.getLastVisitedDate();
            historico += url + "\n";
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Histórico");
        alert.setHeaderText("Histórico de navegação");
        alert.setContentText(historico);
        alert.showAndWait();
        
    }

    public void back(){
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        int currentIndex = history.getCurrentIndex();

        if(currentIndex > 0){
            history.go(-1);
            textField.setText(entries.get(currentIndex - 1).getUrl());
        }
    }

    public void foward(){
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        int currentIndex = history.getCurrentIndex();

        if(currentIndex + 1 < entries.size()){
            history.go(1);
            textField.setText(entries.get(currentIndex + 1).getUrl());
        }
    }

    public void executeJS(){
        engine.executeScript("window.location = \"https://www.youtube.com\";");
        textField.setText("https://www.youtube.com");
    }
    
}

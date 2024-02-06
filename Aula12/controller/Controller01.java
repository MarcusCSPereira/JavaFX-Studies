package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Scanner;

public class Controller01 {
    
    @FXML
    TextField textfield;
    @FXML
    PasswordField passwordfield;

    File file = new File("database/data.txt");
    HashMap<String, String> loginInfo = new HashMap<>();    
    

    /*public void read(ActionEvent event){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean found = false;
            
            String username = textfield.getText();
            String password = passwordfield.getText();
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    break;
                }
            }
            
            reader.close();
            
            if (found) {
                showAlert("Login Successful", "Welcome " + username + "!");
            } else {
                showAlert("Login Failed", "Invalid username or password.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to read from file.");
        }*/ // This is the old read method

        public void read(ActionEvent event) {
            try {
                updateUsernamesAndPasswords();
                String username = textfield.getText();
                String password = passwordfield.getText();
                if (loginInfo.containsKey(username) && loginInfo.get(username).equals(password)) {
                    showAlert("Login Successful", "Welcome " + username + "!");
                } else {
                    showAlert("Login Failed", "Invalid username or password.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to read from file.");
            }
        }

        private void showAlert(String string, String string2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(string);
            alert.setHeaderText(null);
            alert.setContentText(string2);
            alert.show();
        }

        private void updateUsernamesAndPasswords() throws IOException {
            Scanner scanner = new Scanner(file);
            loginInfo.clear(); // Limpa o mapa existente
            while (scanner.hasNext()) {
                String[] splitInfo = scanner.nextLine().split(",");
                loginInfo.put(splitInfo[0], splitInfo[1]);
            }
            scanner.close();
        }
    
    
    public void write(ActionEvent event){
        try {
            String username = textfield.getText();
            String password = passwordfield.getText();
            updateUsernamesAndPasswords();
            if(loginInfo.containsKey(username)){
                showAlert("Error", "Username already exists.");
            } else {
                showAlert("Success", "Account created successfully.");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
    
                writer.write(username + "," + password + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

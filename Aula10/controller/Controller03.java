package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.EncryptorAES;
import model.EncryptorTripleDES;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Controller03 {

    EncryptorAES encryptorAES = new EncryptorAES();
    EncryptorTripleDES encryptorTripleDES = new EncryptorTripleDES();

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField inputTextField;

    @FXML
    private TextField outputTextField;

    @FXML
    private RadioButton aseRadio;

    @FXML
    private ToggleGroup encryptionDecryptionType;

    @FXML
    private RadioButton tripleDSERadio;

    public void Controller() throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException {
    }

    @FXML
    void decryptButton(ActionEvent event) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        String input = inputTextField.getText();
        String key = keyTextField.getText();
        String encryptedString = null;

        if(encryptionDecryptionType.getSelectedToggle() == aseRadio){
            encryptedString = encryptorAES.decrypt(input,key);
        } else if(encryptionDecryptionType.getSelectedToggle() == tripleDSERadio){
            encryptedString = encryptorTripleDES.decrypt(input,key);
        }
        outputTextField.setText(encryptedString);
    }


    @FXML
    void encryptButton(ActionEvent event) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {

        String key = keyTextField.getText();
        String input = inputTextField.getText();
        String encryptedString = null;
        if(encryptionDecryptionType.getSelectedToggle() == aseRadio){
            encryptedString = encryptorAES.encrypt(input,key);
        } else if(encryptionDecryptionType.getSelectedToggle() == tripleDSERadio){
            encryptedString = encryptorTripleDES.encrypt(input,key);
        }
        outputTextField.setText(encryptedString);

    }

}
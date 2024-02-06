package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Encryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Controller01 {

    Encryptor encryptor = new Encryptor();

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField inputTextField;

    @FXML
    private TextField outputTextField;

    @FXML
    void decryptButton(ActionEvent event) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        // Could be 128, 192, or 256 bits.
        byte[] key = encryptor.stringToByteArray(keyTextField.getText());
        String input = inputTextField.getText();
        String encryptedString = encryptor.decrypt(input,key);
        outputTextField.setText(encryptedString);
    }


    @FXML
    void encryptButton(ActionEvent event) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        //Could be 128, 192, or 256 bits.
        byte[] key = encryptor.stringToByteArray(keyTextField.getText());
        String input = inputTextField.getText();

        String encryptedString = encryptor.encrypt(input,key);
        outputTextField.setText(encryptedString);
    }
}


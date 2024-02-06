package model;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class EncryptorTripleDES {

    private final String transformation = "DESede/CBC/PKCS5Padding";
    private String algorithm = "DESede";

    public String encrypt(String input, String keyString) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digestOfPassword = md.digest(keyString.getBytes());

        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        byte[] plainTextBytes = input.getBytes();
        byte[] cipherText = cipher.doFinal(plainTextBytes);
        String outputString = "";
        for (byte a:cipherText) {
            outputString = outputString + a + " ";
        }

        return String.valueOf(outputString);
    }


    public String decrypt(String ciphertext, String keyString)
            throws InvalidKeyException,	NoSuchPaddingException,
            InvalidAlgorithmParameterException,	IllegalBlockSizeException,
            BadPaddingException, NoSuchAlgorithmException {

        byte [] cipherTextByteArray = stringToByteArray(ciphertext);

        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digestOfPassword = md.digest(keyString.getBytes());

        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        SecretKey secretKey = new SecretKeySpec(keyBytes, algorithm);
        IvParameterSpec iv = new IvParameterSpec(new byte[8]);

        Cipher decryptor = Cipher.getInstance(transformation);
        decryptor.init(Cipher.DECRYPT_MODE, secretKey, iv);

        byte[] decrypted = decryptor.doFinal(cipherTextByteArray);

        return new String(decrypted);
    }

    private byte[] stringToByteArray(String string){
        String[] stringFragments = string.split(" ");

        byte[] byteArray = new byte[8];
        for (int i = 0; i < stringFragments.length; i++) {
            byteArray[i] = Byte.parseByte(stringFragments[i]);
        }
        return byteArray;
    }

    public static void main(String[] args) throws Exception {
        //Test for TripleDES
        String key = "TestKey";

        String testString = "Secret";

        EncryptorTripleDES encryptorTripleDES = new EncryptorTripleDES();

        String encrypted = encryptorTripleDES.encrypt(testString, key);
        System.out.println(encrypted);

        String test = "[12, -37, -92, 118, 24, -49, -44, -75]";

        String decrypted = encryptorTripleDES.decrypt("126 -86 29 -79 64 -86 31 -89", key);
        System.out.println(decrypted);
    }
}
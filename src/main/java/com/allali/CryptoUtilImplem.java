package com.allali;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;

public class CryptoUtilImplem {

    public String encodeToBase64(byte[] data ){
     return Base64.getEncoder().encodeToString(data);
    }
    public byte[] decodeFromBase64(String data){
        return Base64.getDecoder().decode(data.getBytes());
    }
    public String encodeToBase64URL(byte[] data ){
        return Base64.getUrlEncoder().encodeToString(data);
    }
    public byte[] decodeFromBase64URL(String data){
        return Base64.getUrlDecoder().decode(data.getBytes());
    }
    public String encryptData(String data , SecretKey secretKey) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        //SecretKey secretKey = new SecretKeySpec(key.getBytes(),0,key.length(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        byte[] encodedEncryptedData = Base64.getEncoder().encode(encryptedData);
        return new String(encodedEncryptedData);
    }
    public String decryptData(String encryptedData , SecretKey secretKey) throws Exception{
        byte[] decodedEncryptedData = Base64.getDecoder().decode(encryptedData);
        //SecretKey secretKey = new SecretKeySpec(key.getBytes(),0,key.length(),"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[] decryptedData = cipher.doFinal(decodedEncryptedData);
        return new String(decryptedData);
    }
    public SecretKey keyGenerate() throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }
    //RSA algorithm
    public KeyPair keyPairGenerate() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }
    public PrivateKey privateKeyGenerate() throws Exception {
        KeyPair keyPair = keyPairGenerate();
        return keyPair.getPrivate();
    }
    public PublicKey publicKeyGenerate() throws Exception {
        KeyPair keyPair = keyPairGenerate();
        return keyPair.getPublic();
    }
}

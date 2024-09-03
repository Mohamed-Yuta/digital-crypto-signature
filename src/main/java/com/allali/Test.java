package com.allali;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Base64;

public class Test{
    public static void main(String[] args) throws Exception{
        CryptoUtilImplem cryptoUtilImplem = new CryptoUtilImplem();
        String message = "This is my test message  ";
        SecretKey secretKey = cryptoUtilImplem.keyGenerate();
        String encryptedData = cryptoUtilImplem.encryptData(message,secretKey);
        System.out.println(encryptedData);
        String decryptedData = cryptoUtilImplem.decryptData(encryptedData,secretKey);
        System.out.println(decryptedData);

    }
}
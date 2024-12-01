package com.allali.RSA;

import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class TestRSA {
    public static void main(String[] args) throws Exception {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("Private key :");
        System.out.println(Arrays.toString(privateKey.getEncoded()));
        System.out.println("Public key :");
        System.out.println(Arrays.toString(publicKey.getEncoded()));
        System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
    }
}

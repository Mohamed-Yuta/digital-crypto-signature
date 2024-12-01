package com.allali.RSA;

import com.allali.CryptoUtilImplem;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
public class GenerateRSAKeys {
    public static void main(String[] args) throws Exception {
        CryptoUtilImplem cryptoUtilImplem = new CryptoUtilImplem();
        KeyPair keyPair = cryptoUtilImplem.keyPairGenerate();
        PrivateKey privateKey = cryptoUtilImplem.privateKeyGenerate();
        PublicKey publicKey = cryptoUtilImplem.publicKeyGenerate();
        System.out.println("Private key :");
        System.out.println(Arrays.toString(privateKey.getEncoded()));
        System.out.println(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        System.out.println("Public key :");
        System.out.println(Arrays.toString(publicKey.getEncoded()));
        System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));

    }

}

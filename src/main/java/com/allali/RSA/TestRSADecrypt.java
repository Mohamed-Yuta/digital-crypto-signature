package com.allali.RSA;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class TestRSADecrypt {
    public static void main(String[] args) throws Exception {
        String privateKeyBase64 ="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALVtw7wOM+EhiyUHl3Rroihjyq9kVkJ0r0IItd/4XlhEnGg6Yr1cahXf9gTA4/jIOS+KgU+sP5C6Ft5qDPvmTGlWA9umv/g7tpsmDIuNXshSr1CKjGtGCsyasXi9bLVQsef1Wd1l+KidGmkO1KXJ8PvkF9veZvo1oC1Enym+t4UfAgMBAAECgYA5pjm6cUbh5A87QnjJOQRLUj5O0hKoxjwEPxFPrDOKV67dXaQPaKSa89HQO9yUqkaliRzCzMhb/A2VOdyLVGf1zbWPCFemu6me0Gz00PF59s/z9Z3jcbk0W095LiuZajGBAPTEOW8FKBNUKHVD94bLu+6p1AYjL7L58wba5xUCdQJBANdRHQ2NP6lHxBAE7CLfIncQX+3HA4ZFGpp5gZ6PfMxrALUxEw0ywP8G8Ara1Dcfi3qdj3UgroJG6D36GGfQTwMCQQDXtXuh4x2IRK5PFEmz7CFmsFf/WJp7WK2ZhfD3Tqrp6xITE6mNWrHNgnWIdGByoZpfQda1Iuzwu50Ov5jsDTi1AkA3pFaFsgLJlCoumZcMS+10J18i61MV17XQRaYhe6MckGpWaKArwPnu7bQKmhJNTHGW9jCkbBWsxPYvTfoQmdxRAkBj9cPfF0I+PaWRG9Ozvv8TeTCuMb8U3dlExZ8O27O0RqzPjlMKIDc5BvW0UEnJlT3WWspGknK+dBKqHPuel9npAkBXf+UJr0LG0kAd98XGg5qzXg1XOJeDX7bUyPVTEzhdcVrjTNwsT5tBGDK1dxySGI9jFlMasSDqbt72UdMJkvbQ";
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.getDecoder().decode(privateKeyBase64);
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedKey));

        String message = "eO6bjCJp56LG0WpX4qAqjKQZXG+jY3sXrLEIRl6seyIhpQeW07gaoHjROddQL9gv/lqphCNQ3juwb4thpfxOqLTPIsTRHriV8j/nXn+Npc91YNJ+l+bIhRlS26UAYXrJx3ZIrJq22NPbeJGGSAk55/hv4P8imApfFNDPWQoKREg=";
        System.out.println("Encrypted message :");
        System.out.println(message);
        byte[] decodeEncryptedMessage = Base64.getDecoder().decode(message);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(message));
        System.out.println("Decrypted message : ");
        System.out.println(new String(decryptedBytes));

    }
}

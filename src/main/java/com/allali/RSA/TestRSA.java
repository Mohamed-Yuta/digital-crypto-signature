package com.allali.RSA;

import com.allali.CryptoUtilImplem;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class TestRSA {
    public static void main(String[] args) throws Exception {

        /*
        Private key :
[48, -126, 2, 117, 2, 1, 0, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 4, -126, 2, 95, 48, -126, 2, 91, 2, 1, 0, 2, -127, -127, 0, -75, 109, -61, -68, 14, 51, -31, 33, -117, 37, 7, -105, 116, 107, -94, 40, 99, -54, -81, 100, 86, 66, 116, -81, 66, 8, -75, -33, -8, 94, 88, 68, -100, 104, 58, 98, -67, 92, 106, 21, -33, -10, 4, -64, -29, -8, -56, 57, 47, -118, -127, 79, -84, 63, -112, -70, 22, -34, 106, 12, -5, -26, 76, 105, 86, 3, -37, -90, -65, -8, 59, -74, -101, 38, 12, -117, -115, 94, -56, 82, -81, 80, -118, -116, 107, 70, 10, -52, -102, -79, 120, -67, 108, -75, 80, -79, -25, -11, 89, -35, 101, -8, -88, -99, 26, 105, 14, -44, -91, -55, -16, -5, -28, 23, -37, -34, 102, -6, 53, -96, 45, 68, -97, 41, -66, -73, -123, 31, 2, 3, 1, 0, 1, 2, -127, -128, 57, -90, 57, -70, 113, 70, -31, -28, 15, 59, 66, 120, -55, 57, 4, 75, 82, 62, 78, -46, 18, -88, -58, 60, 4, 63, 17, 79, -84, 51, -118, 87, -82, -35, 93, -92, 15, 104, -92, -102, -13, -47, -48, 59, -36, -108, -86, 70, -91, -119, 28, -62, -52, -56, 91, -4, 13, -107, 57, -36, -117, 84, 103, -11, -51, -75, -113, 8, 87, -90, -69, -87, -98, -48, 108, -12, -48, -15, 121, -10, -49, -13, -11, -99, -29, 113, -71, 52, 91, 79, 121, 46, 43, -103, 106, 49, -127, 0, -12, -60, 57, 111, 5, 40, 19, 84, 40, 117, 67, -9, -122, -53, -69, -18, -87, -44, 6, 35, 47, -78, -7, -13, 6, -38, -25, 21, 2, 117, 2, 65, 0, -41, 81, 29, 13, -115, 63, -87, 71, -60, 16, 4, -20, 34, -33, 34, 119, 16, 95, -19, -57, 3, -122, 69, 26, -102, 121, -127, -98, -113, 124, -52, 107, 0, -75, 49, 19, 13, 50, -64, -1, 6, -16, 10, -38, -44, 55, 31, -117, 122, -99, -113, 117, 32, -82, -126, 70, -24, 61, -6, 24, 103, -48, 79, 3, 2, 65, 0, -41, -75, 123, -95, -29, 29, -120, 68, -82, 79, 20, 73, -77, -20, 33, 102, -80, 87, -1, 88, -102, 123, 88, -83, -103, -123, -16, -9, 78, -86, -23, -21, 18, 19, 19, -87, -115, 90, -79, -51, -126, 117, -120, 116, 96, 114, -95, -102, 95, 65, -42, -75, 34, -20, -16, -69, -99, 14, -65, -104, -20, 13, 56, -75, 2, 64, 55, -92, 86, -123, -78, 2, -55, -108, 42, 46, -103, -105, 12, 75, -19, 116, 39, 95, 34, -21, 83, 21, -41, -75, -48, 69, -90, 33, 123, -93, 28, -112, 106, 86, 104, -96, 43, -64, -7, -18, -19, -76, 10, -102, 18, 77, 76, 113, -106, -10, 48, -92, 108, 21, -84, -60, -10, 47, 77, -6, 16, -103, -36, 81, 2, 64, 99, -11, -61, -33, 23, 66, 62, 61, -91, -111, 27, -45, -77, -66, -1, 19, 121, 48, -82, 49, -65, 20, -35, -39, 68, -59, -97, 14, -37, -77, -76, 70, -84, -49, -114, 83, 10, 32, 55, 57, 6, -11, -76, 80, 73, -55, -107, 61, -42, 90, -54, 70, -110, 114, -66, 116, 18, -86, 28, -5, -98, -105, -39, -23, 2, 64, 87, 127, -27, 9, -81, 66, -58, -46, 64, 29, -9, -59, -58, -125, -102, -77, 94, 13, 87, 56, -105, -125, 95, -74, -44, -56, -11, 83, 19, 56, 93, 113, 90, -29, 76, -36, 44, 79, -101, 65, 24, 50, -75, 119, 28, -110, 24, -113, 99, 22, 83, 26, -79, 32, -22, 110, -34, -10, 81, -45, 9, -110, -10, -48]
MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALVtw7wOM+EhiyUHl3Rroihjyq9kVkJ0r0IItd/4XlhEnGg6Yr1cahXf9gTA4/jIOS+KgU+sP5C6Ft5qDPvmTGlWA9umv/g7tpsmDIuNXshSr1CKjGtGCsyasXi9bLVQsef1Wd1l+KidGmkO1KXJ8PvkF9veZvo1oC1Enym+t4UfAgMBAAECgYA5pjm6cUbh5A87QnjJOQRLUj5O0hKoxjwEPxFPrDOKV67dXaQPaKSa89HQO9yUqkaliRzCzMhb/A2VOdyLVGf1zbWPCFemu6me0Gz00PF59s/z9Z3jcbk0W095LiuZajGBAPTEOW8FKBNUKHVD94bLu+6p1AYjL7L58wba5xUCdQJBANdRHQ2NP6lHxBAE7CLfIncQX+3HA4ZFGpp5gZ6PfMxrALUxEw0ywP8G8Ara1Dcfi3qdj3UgroJG6D36GGfQTwMCQQDXtXuh4x2IRK5PFEmz7CFmsFf/WJp7WK2ZhfD3Tqrp6xITE6mNWrHNgnWIdGByoZpfQda1Iuzwu50Ov5jsDTi1AkA3pFaFsgLJlCoumZcMS+10J18i61MV17XQRaYhe6MckGpWaKArwPnu7bQKmhJNTHGW9jCkbBWsxPYvTfoQmdxRAkBj9cPfF0I+PaWRG9Ozvv8TeTCuMb8U3dlExZ8O27O0RqzPjlMKIDc5BvW0UEnJlT3WWspGknK+dBKqHPuel9npAkBXf+UJr0LG0kAd98XGg5qzXg1XOJeDX7bUyPVTEzhdcVrjTNwsT5tBGDK1dxySGI9jFlMasSDqbt72UdMJkvbQ
Public key :
[48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -93, -90, 16, -65, -17, -104, 42, -65, 118, -28, -34, 39, -115, 60, -94, -66, 84, 23, -18, -31, 69, -66, -92, -35, 6, 123, 117, 84, -101, 32, 26, 121, -69, -51, -71, 3, -38, 84, 53, -55, 40, -91, 97, -33, 58, 44, 112, 23, -33, 110, -118, 105, -83, -105, 123, -9, -71, 67, -78, -40, -103, 54, -116, 53, 5, -16, -101, -86, 33, -125, -7, -63, -6, 12, -95, 40, -54, 50, 81, 16, 112, 71, -116, -94, 38, 117, 92, 19, -27, -90, 10, -73, -17, -94, 32, 11, -123, 97, 106, 58, 79, -98, -110, 106, 105, -87, -54, -6, -49, 39, -23, 62, -50, -28, -8, 65, 30, -121, -55, -37, -115, -26, -120, -17, -2, 105, -36, 31, 2, 3, 1, 0, 1]
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjphC/75gqv3bk3ieNPKK+VBfu4UW+pN0Ge3VUmyAaebvNuQPaVDXJKKVh3zoscBffbopprZd797lDstiZNow1BfCbqiGD+cH6DKEoyjJREHBHjKImdVwT5aYKt++iIAuFYWo6T56SammpyvrPJ+k+zuT4QR6HyduN5ojv/mncHwIDAQAB
         */

        String publicKeyBase64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjphC/75gqv3bk3ieNPKK+VBfu4UW+pN0Ge3VUmyAaebvNuQPaVDXJKKVh3zoscBffbopprZd797lDstiZNow1BfCbqiGD+cH6DKEoyjJREHBHjKImdVwT5aYKt++iIAuFYWo6T56SammpyvrPJ+k+zuT4QR6HyduN5ojv/mncHwIDAQAB";
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey =Base64.getDecoder().decode(publicKeyBase64);
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));


        String message = "Hello World !!";
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        System.out.println("Encrypted message : ");
        System.out.println(Base64.getEncoder().encodeToString(encryptedBytes));

    }
}

package Encryption;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

class EncryptionExample {
    private static PublicKey setPublicKey(byte[] keyBytes) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }

    private static PrivateKey setPrivateKey(byte[] keyBytes) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(spec);
    }


    final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJzzibV/Xkp/ofPXjrOyPO5M5C0xnrQUB+4ve9uSg3oTrZ6FOz/Lc7xrq4Snn515aGSPi2oJX+/rprnMbg09jvbKYYqcF9WBrKRuqJALlorQS93ishkU1EHR6lllfAogm2CF9oANV2R0BUBTAHGqh4GCQhZHfoLrwuc1x0awxTrQIDAQAB";
    final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAInPOJtX9eSn+h89eOs7I87kzkLTGetBQH7i9725KDehOtnoU7P8tzvGurhKefnXloZI+Laglf7+umucxuDT2O9sphipwX1YGspG6okAuWitBL3eKyGRTUQdHqWWV8CiCbYIX2gA1XZHQFQFMAcaqHgYJCFkd+guvC5zXHRrDFOtAgMBAAECgYAlYHW69FV16fVV6cdVDZo9sCMdTsI142HJyGdnJsP4qpsapP+mzoEoDlNwTorcr5Nc4ofKiK2GFrKbI09xhSPODmQCm7lzegxq71fevl9EibZHwj+IRhUJk093S+QIGaNtpYshd05Uy4B5wzusMdp4S7yiNF48KuWC3hkTdF/S5QJBAL8GXJ+yZYTmBv9YBuPXbWWwwyY9Na1IH9U5YppBipl7sR+gdnzSECAUD8jfkZD6+PCGmKBFVPSbrwTfAMPw4tMCQQC4rxZcEIQYDOXKcsdiWDmvEfAyfQPCwsRFOwSwmY9J9lDwZYxrhJmkulOXtGeTDvRfJsYtdRAFSiq5I0HFct9/AkACUfV2CxiokJKtL0iGI+u0PH1iTYQFYsbgNB46eWlRi+sO00gdJAAGI7g9XFnMRQAZC8l2yODLR8jMalj8CET5AkABj6lWueUD9wfyQCojUK+cJUCsjJX9jXvvQeJ2Q7YMYAKrJZCcUBCkbdbLD4FYouW58C/4rmamRMw7qGqj6qatAkEAiUp0bttuXIOsba8pxeVOHJVdU4yIu/U8j4Uu46PK3RUK1wbyaIGFWa9MXNMUtzrHzwOrW8UXG7Xj8jSFjeAMjg==";

    @Test
    public void givenRsaKeyPair_encryptValue() throws Exception {

        String secretMessage = "This Is Secret Message";


        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);

        PublicKey publicKey = setPublicKey(publicKeyBytes);
        PrivateKey privateKey = setPrivateKey(privateKeyBytes);

        Cipher encryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");


        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

        Assertions.assertNotEquals(secretMessage, Base64.getEncoder().encodeToString(encryptedMessageBytes));
    }

    @Test
    public void givenRsaKeyPair_decryptValue() throws Exception {

        String secretMessage = "This Is Secret Message";


        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);

        PublicKey publicKey = setPublicKey(publicKeyBytes);
        PrivateKey privateKey = setPrivateKey(privateKeyBytes);

        Cipher encryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

        Cipher decryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
        String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);


        Assertions.assertEquals(secretMessage, decryptedMessage);
    }
}

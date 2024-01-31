package org.saurabh;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class AESEncryptionDecryptionWithLongSecretKey {

    // This is a fixed secret key (for educational purposes only)
    private static final String FIXED_SECRET_KEY_STRING = "ThisIsAVeryLongSecretKeyForAES256EncryptionWith124Characters"; // Should be 32 characters for AES-256
    private static final String FIXED_SECRET_KEY_STRING2 = "ThisIsAVeryLongSecretKeyForAES256EncryptionWith124Characters"; // Should be 32 characters for AES-256

    public static void main(String[] args) throws Exception {
        // Convert the fixed secret key string to a SecretKey object
        SecretKey secretKey = generateSecretKey(FIXED_SECRET_KEY_STRING);
        SecretKey secretKey2 = generateSecretKey(FIXED_SECRET_KEY_STRING2);

        // Your original message
        String originalMessage = "Hello, AES Encryption and Decryption!";

        // Encrypt the message
        String encryptedMessage = encrypt(originalMessage, secretKey);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, secretKey2);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    private static SecretKey generateSecretKey(String keyString) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = sha.digest(keyString.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(keyBytes, "AES");
    }

    private static String encrypt(String plaintext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decrypt(String ciphertext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}

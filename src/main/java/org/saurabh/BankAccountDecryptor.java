package org.saurabh;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class BankAccountDecryptor {

    public static String decryptFrontendData(String encryptedData) throws Exception {
        String decryptionKey = "ASDFGHJKLASDFGHJ";
        String initializationVector = "cHr+mQdmOt7S9vtDwgYtdw==";

        SecretKeySpec secretKeySpec = new SecretKeySpec(decryptionKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(Base64.getDecoder().decode(initializationVector)));

        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes).trim(); // trim to remove leading and trailing whitespaces
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("0x01", 14, 66,
                "ipuBGcIw/awhDBITI6XV6Q==", "8+roeqZKgN1QciQlFJPj30M8CJ2SFa+OatxSMGSptic=",
                "iq65ILE62IwSI2A1Z8K9hEM8CJ2SFa+OatxSMGSptic=", null, "m4+WDqFIgdxRcCUkFJLi3mEdKbyzDrSVccdJK3+yrTw=");

        try {
            System.out.println("Decrypted Bank Account Details:");
            System.out.println("Account Holder Name: " + decryptFrontendData(bankAccount.getAccountHolderName()));
            System.out.println("Account Number: " + decryptFrontendData(bankAccount.getAccountNumber()));
            System.out.println("Bank Name: " + decryptFrontendData(bankAccount.getBankName()));
            System.out.println("IFSC Code: " + decryptFrontendData(bankAccount.getIfscCode()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

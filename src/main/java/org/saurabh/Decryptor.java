package org.saurabh;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Decryptor {

    public static String decryptFrontendData(String encryptedData) throws Exception {
        String key = "ASDFGHJKLASDFGHJ";
        String iv = "cHr+mQdmOt7S9vtDwgYtdw==";

        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(Base64.getDecoder().decode(iv)));

        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes).trim(); // trim to remove leading and trailing whitespaces
    }


    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("0x01", 14, 66,
                "ipuBGcIw/awhDBITI6XV6Q==", "8+roeqZKgN1QciQlFJPj30M8CJ2SFa+OatxSMGSptic=",
                "iq65ILE62IwSI2A1Z8K9hEM8CJ2SFa+OatxSMGSptic=", null, "m4+WDqFIgdxRcCUkFJLi3mEdKbyzDrSVccdJK3+yrTw=");

        try {
            System.out.println("Decrypted Bank Account Details:");
            System.out.println("Account Holder Name: " + Decryptor.decryptFrontendData(bankAccount.getAccountHolderName()));
            System.out.println("Account Number: " + Decryptor.decryptFrontendData(bankAccount.getAccountNumber()));
            System.out.println("Bank Name: " + Decryptor.decryptFrontendData(bankAccount.getBankName()));
            System.out.println("IFSC Code: " + Decryptor.decryptFrontendData(bankAccount.getIfscCode()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





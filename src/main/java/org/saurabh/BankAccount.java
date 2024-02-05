package org.saurabh;

public class BankAccount {
    private String isDefaultAccount;
    private int bankAccountId;
    private int userId;
    private String accountHolderName;
    private String accountNumber;
    private String bankName;
    private String bbanCode;
    private String ifscCode;

    // Constructor
    public BankAccount(String isDefaultAccount, int bankAccountId, int userId, String accountHolderName,
                       String accountNumber, String bankName, String bbanCode, String ifscCode) {
        this.isDefaultAccount = isDefaultAccount;
        this.bankAccountId = bankAccountId;
        this.userId = userId;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.bbanCode = bbanCode;
        this.ifscCode = ifscCode;
    }

    // Getters and setters (You can generate these automatically in most IDEs)

    public String getIsDefaultAccount() {
        return isDefaultAccount;
    }

    // Other getters and setters...

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    // toString method to print the object details
    @Override
    public String toString() {
        return "BankAccount{" +
                "isDefaultAccount='" + isDefaultAccount + '\'' +
                ", bankAccountId=" + bankAccountId +
                ", userId=" + userId +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bbanCode='" + bbanCode + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                '}';
    }

    // You can add other methods or modify the class based on your requirements.


    public void setIsDefaultAccount(String isDefaultAccount) {
        this.isDefaultAccount = isDefaultAccount;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBbanCode() {
        return bbanCode;
    }

    public void setBbanCode(String bbanCode) {
        this.bbanCode = bbanCode;
    }
}

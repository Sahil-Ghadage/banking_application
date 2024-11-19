package com.sahilg.banking.accounts.constant;

public enum AccountConstants {
    STATUS_201("201", "Account created successfully"),
    STATUS_200("200", "Request processed successfully"),
    STATUS_417_UPDATE("417", "Update operation failed. Please try again or contact admin"),
    STATUS_417_DELETE("417", "Delete operation failed. Please try again or contact admin");

    private final String code;
    private final String message;

    // Constructor to initialize the enum with the code and message
    AccountConstants(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

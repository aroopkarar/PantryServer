package com.test.sbmvc.CO;

public class ResetPasswordCO extends ChangePasswordCO {

    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}

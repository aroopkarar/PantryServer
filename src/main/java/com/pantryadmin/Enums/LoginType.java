package com.pantryadmin.Enums;

public enum LoginType {
    EMAIL("EMAIL"),
    MOBILE("MOBILE"),
    CUSTOMER_ID("CUSTOMER_ID");

    private String key;

    LoginType(String key) {
        this.key = key;
    }
}

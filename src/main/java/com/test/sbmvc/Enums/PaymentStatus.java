package com.test.sbmvc.Enums;

public enum PaymentStatus {
    SUCCESS("SUCCESS","Payment Successfull"),FAILED("FAILED","Payment Failed");
    private final String key;
    private final String value;

    PaymentStatus(String key, String value)
    {
        this.key=key;
        this.value=value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

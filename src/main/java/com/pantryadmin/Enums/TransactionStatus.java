package com.pantryadmin.Enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionStatus {
    SUCCESS("SUCCESS","Payment Successfull"),FAILED("FAILED","Payment Failed");
    private final String key;
    private final String value;

    private static Map<String,String> paymentStatusMap = new HashMap<>();

    static {
        for (TransactionStatus orderStatus : TransactionStatus.values()) {
            paymentStatusMap.put(orderStatus.getKey(),orderStatus.getValue());
        }
    }

    public static String getValue(String status) {
        return  paymentStatusMap.get(status);
    }

    TransactionStatus(String key, String value)
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

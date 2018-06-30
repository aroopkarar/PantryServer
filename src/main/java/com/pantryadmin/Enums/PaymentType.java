package com.pantryadmin.Enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentType {

    COD("COD","Cash On Delivery"),  CARD("CARD","Credit/Debit Card Payment");
    private final String key;
    private final String value;

    private static Map<String,String> orderStatusMap = new HashMap<>();

    static {
        for (PaymentType paymentType : PaymentType.values()) {
            orderStatusMap.put(paymentType.getKey(),paymentType.getValue());
        }
    }

    public static String getValue(String status) {
        return  orderStatusMap.get(status);
    }

    PaymentType(String key, String value)
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

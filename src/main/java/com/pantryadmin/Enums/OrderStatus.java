package com.pantryadmin.Enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {
    NEW("NEW","New Order Placed"),TRANSIT("TRANSIT","Order is in Transit"),COMPLETE("COMPLETE","Order Completed/Delivered");
    private final String key;
    private final String value;

    private static Map<String,String> orderStatusMap = new HashMap<>();

    static {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            orderStatusMap.put(orderStatus.getKey(),orderStatus.getValue());
        }
    }

    public static String getValue(String status) {
        return  orderStatusMap.get(status);
    }

    OrderStatus(String key, String value)
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

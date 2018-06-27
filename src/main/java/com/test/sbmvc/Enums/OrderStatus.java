package com.test.sbmvc.Enums;

public enum OrderStatus {
    NEW("New","New Order Placed"),TRANSIT("TRANSIT","Order is in Transit"),COMPLETE("COMPLETE","Order Completed/Delivered");
    private final String key;
    private final String value;

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

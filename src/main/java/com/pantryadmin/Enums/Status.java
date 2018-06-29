package com.pantryadmin.Enums;

public enum Status {
    ACTIVE(1), INACTIVE(0), DELETED(100);
    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

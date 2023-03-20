package org.kata.model;

public enum PointEnum {
    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("Advantage"),
    WIN("Win");

    private final String pointValue;

    PointEnum(String pointValue) {
        this.pointValue = pointValue;
    }
    public String getPointValue() {
        return pointValue;
    }

}

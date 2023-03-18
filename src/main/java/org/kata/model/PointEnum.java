package org.kata.model;

public enum PointEnum {
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40),
    DEUCE(0),
    ADVANTAGE(1);

    private final int pointValue;
    PointEnum(int pointValue) {
        this.pointValue = pointValue;
    }
    public int getPointValue() {
        return pointValue;
    }
}

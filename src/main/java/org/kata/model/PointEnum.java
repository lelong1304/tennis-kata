package org.kata.model;

public enum PointEnum {
    ZERO(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40),
    ADVANTAGE(1),
    WIN(2);


    private final int pointValue;

    PointEnum(int pointValue) {
        this.pointValue = pointValue;
    }
    public int getPointValue() {
        return pointValue;
    }

}

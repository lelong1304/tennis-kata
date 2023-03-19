package org.kata.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private String name;
    private List<PointEnum> points;

    public Player(String name) {
        this.name = name;
        points = new ArrayList<>();
    }

    public void winBall(boolean isDeuced){
        PointEnum point = getNextPoint(isDeuced);
        this.points.add(point);
    }

    public PointEnum getLastPoint() {
        return points.isEmpty() ? PointEnum.ZERO : points.get(points.size()-1);
    }

    private PointEnum getNextPoint(boolean isDeuced) {
        PointEnum lastPoint = getLastPoint();
        if (!isDeuced) {
            if (lastPoint == PointEnum.ZERO) {
                return PointEnum.FIFTEEN;
            }
            if (lastPoint == PointEnum.FIFTEEN) {
                return PointEnum.THIRTY;
            }
            if (lastPoint == PointEnum.THIRTY) {
                return PointEnum.FORTY;
            }
        } else {
            if (lastPoint == PointEnum.FORTY) {
                return PointEnum.DEUCE;
            }
            if (lastPoint == PointEnum.DEUCE) {
                return PointEnum.ADVANTAGE;
            }
        }
        return PointEnum.WIN;
    }

}

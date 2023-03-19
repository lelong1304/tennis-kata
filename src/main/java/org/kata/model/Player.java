package org.kata.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static org.kata.model.StatusEnum.*;

@Data
public class Player {
    private String name;
    private List<PointEnum> points;
    private char tag;

    public Player(String name, char tag) {
        this.name = name;
        points = new ArrayList<>();
        this.tag = tag;
    }

    public void playBall(char ball, StatusEnum gameStatus) {
        PointEnum point = getNextPoint(ball, gameStatus);
        if (point != null) {
            this.points.add(point);
        }
    }

    private boolean isWinningBall(char ball) {
        return tag == ball;
    }

    public PointEnum getLastPoint() {
        return points.isEmpty() ? PointEnum.ZERO : points.get(points.size() - 1);
    }

    private PointEnum getNextPoint(char ball, StatusEnum gameStatus) {
        PointEnum lastPoint = getLastPoint();
        if (isWinningBall(ball)) {
            if (gameStatus == NO_WIN) {return nextPointWhenGameIsNoWin(lastPoint);}
            if (gameStatus == DEUCE) {return PointEnum.ADVANTAGE;}
            if (gameStatus == ADVANTAGE && getLastPoint()==PointEnum.ADVANTAGE) {return PointEnum.WIN;}
        } else {
            if (gameStatus == ADVANTAGE) {return PointEnum.FORTY;}
        }
        return null;
    }



    private PointEnum nextPointWhenGameIsNoWin(PointEnum lastPoint) {
        if (lastPoint == PointEnum.ZERO) {
            return PointEnum.FIFTEEN;
        }
        if (lastPoint == PointEnum.FIFTEEN) {
            return PointEnum.THIRTY;
        }
        if (lastPoint == PointEnum.THIRTY) {
            return PointEnum.FORTY;
        }
        return PointEnum.WIN;
    }

}

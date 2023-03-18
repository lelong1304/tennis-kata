package org.kata.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private String name;
    private List<PointEnum> point;

    public Player(String name) {
        this.name = name;
        point = new ArrayList<>();
    }

}

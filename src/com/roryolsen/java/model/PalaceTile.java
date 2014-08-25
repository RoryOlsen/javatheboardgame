package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.terrain.Palace;

/**
 * Created by roryolsen on 8/14/14.
 */
public class PalaceTile extends GameTile {

    private final int value;

    public PalaceTile(int value) {
        this.value = value;
        this.setTerrainType(new Palace(value), new Coordinate(0,0));

    }

    public int getValue() {
        return value;
    }
}
package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.core.Rotation;

/**
 * Created by roryolsen on 8/14/14.
 */
public class PotentialTilePlacement {

    private final GameTile gameTile;
    private final Coordinate location;
    private final Rotation rotation;

    public PotentialTilePlacement(GameTile gameTile, Coordinate location, Rotation rotation) {
        this.gameTile = gameTile;
        this.location = location;
        this.rotation = rotation;
    }

    public GameTile getGameTile() {
        return gameTile;
    }

    public Coordinate getLocation() {
        return location;
    }

    public Rotation getRotation() {
        return rotation;
    }
}

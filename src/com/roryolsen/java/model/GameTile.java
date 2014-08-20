package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/14/14.
 */
public abstract class GameTile {

    private Map<Coordinate, TerrainType> TerrainTypeLocations = new HashMap<>();

    public Map<Coordinate, TerrainType> getTerrainTypeLocations() {
        return TerrainTypeLocations;
    }
}

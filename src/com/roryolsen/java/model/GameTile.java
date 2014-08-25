package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/14/14.
 */
public abstract class GameTile {

    private final Map<Coordinate, TerrainType> terrainTypeLocations = new HashMap<>();

    public Map<Coordinate, TerrainType> getTerrainTypeLocations() {
        return Collections.unmodifiableMap(terrainTypeLocations);
    }

    protected void setTerrainType(TerrainType terrainType, Coordinate coordinate) {
        terrainTypeLocations.put(coordinate, terrainType);
    }
}

package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/14/14.
 */
public abstract class GameTile {

    private int size;
    private Map<Coordinate, TerrainType> coordinateTerrainTypeMap = new HashMap<>();
}

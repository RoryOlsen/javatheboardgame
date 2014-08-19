package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/14/14.
 */
public class Board {

    private final Map<Coordinate, BoardSpace> boardSpaces = new HashMap<>();

    public Map<Coordinate, BoardSpace> getBoardSpaces() {
        return boardSpaces;
    }
}

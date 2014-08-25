package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/14/14.
 */
public class Board {

    private final Map<Coordinate, BoardSpace> boardSpaces = new HashMap<>();

    public BoardSpace getSpace(Coordinate coordinate) {
        return boardSpaces.get(coordinate);
    }

    public void setSpace(Coordinate coordinate, BoardSpace boardSpace) {
        boardSpaces.put(coordinate, boardSpace);
    }

    public Map<Coordinate, BoardSpace> getBoardSpaces() {
        return Collections.unmodifiableMap(boardSpaces);
    }
}

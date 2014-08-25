package com.roryolsen.java.model.terrain;

import com.roryolsen.java.model.TerrainType;

/**
 * Created by roryolsen on 8/25/14.
 */
public class Palace extends TerrainType{

    private final int value;

    public Palace(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

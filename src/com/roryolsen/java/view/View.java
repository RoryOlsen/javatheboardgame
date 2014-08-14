package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;

/**
 * Created by roryolsen on 8/13/14.
 */
public abstract class View {
    public abstract void draw(Coordinate coordinate, char Character, Color color);
    public abstract int getWidth();
    public abstract int getHeight();
}

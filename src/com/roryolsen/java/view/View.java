package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;

/**
 * Created by roryolsen on 8/13/14.
 */
public abstract class View {
    public abstract void draw(Coordinate coordinate, char Character, Color color);
    public abstract int getWidth();
    public abstract int getHeight();

    public void draw(Coordinate coordinate, String string, Color color) {
        for(int i = 0; i < string.length(); i++) {
            draw(coordinate.plus(i, 0), string.charAt(i), color);
        }
    }
}

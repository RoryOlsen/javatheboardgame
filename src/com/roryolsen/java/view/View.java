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
        int currentX = coordinate.getX();
        int currentY = coordinate.getY();
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '\n') {
                currentX = coordinate.getX();
                currentY++;
            } else {
                draw(new Coordinate(currentX, currentY), string.charAt(i), color);
                currentX++;
            }
        }
    }

    public void clear() {
        for(int x = 0; x < this.getWidth(); x++) {
            for(int y = 0; y < this.getHeight(); y++) {
                this.draw(new Coordinate(x, y), ' ', Color.RESET);
            }
        }
    }
}

package com.roryolsen.java.core;

/**
 * Created by roryolsen on 8/13/14.
 */
public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public int hashCode() {
        return 13 * this.getX() + 17 * this.getY();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Coordinate)) {
            return false;
        } else {
            Coordinate other = (Coordinate) obj;
            if (other.getX() == this.getX() && other.getY() == this.getY()) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
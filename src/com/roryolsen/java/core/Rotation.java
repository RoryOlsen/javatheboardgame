package com.roryolsen.java.core;

/**
 * Created by roryolsen on 8/20/14.
 */
public class Rotation {

    private final int numberOfRotations;

    public Rotation(int numberOfRotations) {
        this.numberOfRotations = numberOfRotations;
    }

    public Coordinate rotateClockwise(Coordinate start) {
        double angle = -1 * numberOfRotations * Math.PI/2.0;
        int newX = (int) Math.round(start.getX() * Math.cos(angle) - start.getY() * Math.sin(angle));
        int newY = (int) Math.round(start.getX() * Math.sin(angle) + start.getY() * Math.cos(angle));
        return new Coordinate(newX, newY);
    }
}

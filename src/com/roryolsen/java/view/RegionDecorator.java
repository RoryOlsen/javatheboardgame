package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;

/**
 * Created by roryolsen on 8/13/14.
 */
public class RegionDecorator extends ViewDecorator {

    private final int top;
    private final int left;
    private final int width;
    private final int height;

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public RegionDecorator(View decoratedView, int top, int left, int width, int height) {
        super(decoratedView);
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Coordinate coordinate, char character, Color color) {
        Coordinate transformed = new Coordinate(coordinate.getX() + left, coordinate.getY() + top);
        getDecoratedView().draw(transformed, character, color);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}

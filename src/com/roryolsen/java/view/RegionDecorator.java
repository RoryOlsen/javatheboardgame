package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;

/**
 * Created by roryolsen on 8/13/14.
 */
public class RegionDecorator extends ViewDecorator {

    private final int top;
    private final int left;

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public RegionDecorator(View decoratedView, int top, int left) {
        super(decoratedView);
        this.top = top;
        this.left = left;
    }


    @Override
    public void draw(Coordinate coordinate, char character, Color color) {
        getDecoratedView().draw(new Coordinate(coordinate.getX() + left, coordinate.getY() + top), character, color);
    }

    @Override
    public int getWidth() {
        return getDecoratedView().getWidth();
    }

    @Override
    public int getHeight() {
        return getDecoratedView().getHeight();
    }
}

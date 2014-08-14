package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/13/14.
 */
public class ScrollDecorator extends ViewDecorator{

    private final int top;
    private final int left;
    private final int width;
    private final int height;
    private final Map<Coordinate, ColoredCharacter> characterLocations = new HashMap<>();

    public ScrollDecorator(View decoratedView, int top, int left, int width, int height) {
        super(decoratedView);
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Coordinate coordinate, char character, Color color) {
        characterLocations.put(coordinate, new ColoredCharacter(character, color));

        if (!(coordinate.getX() < left || coordinate.getY() < top ||
                coordinate.getX() > left + getDecoratedView().getWidth() - 1 ||
                coordinate.getY() > top + getDecoratedView().getHeight() - 1)) {
            getDecoratedView().draw(new Coordinate(coordinate.getX() - left, coordinate.getY() - top), character, color);
        }
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

package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/13/14.
 */
public class ScrollDecorator extends ViewDecorator{

    private int top;
    private int left;
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
            Coordinate transformed = new Coordinate(coordinate.getX() - left, coordinate.getY() - top);
            getDecoratedView().draw(transformed, character, color);
        }
    }

    public void scrollRelative(int topDifference, int leftDifference) {
        this.scroll(this.top + topDifference, this.left + leftDifference);
    }

    public void scroll(int top, int left) {
        this.top = top;
        this.left = left;
        for(int x = 0; x < this.getDecoratedView().getWidth(); x++) {
            for(int y = 0; y < this.getDecoratedView().getHeight(); y++) {
                Coordinate decoratedViewCoordinate = new Coordinate(x, y);
                Coordinate scrollDecoratorCoordinate = new Coordinate(x + left, y + top);
                ColoredCharacter currentCharacter = characterLocations.get(scrollDecoratorCoordinate);
                if(currentCharacter == null) {
                    currentCharacter = new ColoredCharacter(' ', Color.RESET);
                }
                this.getDecoratedView().draw(decoratedViewCoordinate, currentCharacter.getCharacter(), currentCharacter.getColor());
            }
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

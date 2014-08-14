package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;

/**
 * Created by roryolsen on 8/13/14.
 */
public class BorderDecorator extends ViewDecorator {

    private final int thickness;
    private final ColoredCharacter character;

    public int getThickness() {
        return thickness;
    }

    public BorderDecorator(View decoratedView, int thickness, ColoredCharacter character) {
        super(decoratedView);
        this.character = character;
        this.thickness = thickness;
        this.drawBorder();
    }

    private void drawBorder() {
        int height = getDecoratedView().getHeight();
        int width = getDecoratedView().getWidth();

        // Top border
        for(int i = 0; i < thickness; i++) {
            for(int x = 0; x < width; x++) {
                getDecoratedView().draw(new Coordinate(x, i), character.getCharacter(), character.getColor());
            }
        }

        // Bottom border
        for(int i = 0; i < thickness; i++) {
            for(int x = 0; x < width; x++) {
                getDecoratedView().draw(new Coordinate(x, height - 1 - i), character.getCharacter(), character.getColor());
            }
        }

        // Left border
        for(int i = 0; i < thickness; i++) {
            for(int y = 0; y < height; y++) {
                getDecoratedView().draw(new Coordinate(i, y), character.getCharacter(), character.getColor());
            }
        }

        // Right border
        for(int i = 0; i < thickness; i++) {
            for(int y = 0; y < height; y++) {
                getDecoratedView().draw(new Coordinate(width - 1 - i, y), character.getCharacter(), character.getColor());
            }
        }
    }

    @Override
    public void draw(Coordinate coordinate, char character, Color color) {
        Coordinate transformed = new Coordinate(coordinate.getX() + thickness, coordinate.getY() + thickness);
        getDecoratedView().draw(transformed, character, color);
    }

    @Override
    public int getWidth() {
        return getDecoratedView().getWidth() - thickness * 2;
    }

    @Override
    public int getHeight() {
        return getDecoratedView().getHeight() - thickness * 2;
    }
}

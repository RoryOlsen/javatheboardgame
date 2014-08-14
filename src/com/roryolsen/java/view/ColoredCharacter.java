package com.roryolsen.java.view;

/**
 * Created by roryolsen on 8/13/14.
 */
public class ColoredCharacter {
    private final char character;
    private final Color color;

    public ColoredCharacter(char character, Color color) {
        this.character = character;
        this.color = color;
    }

    public char getCharacter() {
        return character;
    }

    public Color getColor() {
        return color;
    }



    @Override
    public String toString() {
        return this.getColor().getCode() + this.getCharacter() + Color.RESET.getCode();
    }
}

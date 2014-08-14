package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;
import com.sun.javafx.scene.layout.region.Border;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/13/14.
 */
public class Screen extends View{

    private final Map<Coordinate, ColoredCharacter> characterLocations = new HashMap<>();
    private final int width;
    private final int height;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw (Coordinate coordinate, char character, Color color) {
        characterLocations.put(coordinate, new ColoredCharacter(character, color));
    }

    @Override
    public int getWidth() {
        return this.width;
    }
    @Override
    public int getHeight() {
        return this.height;
    }

    public void print() {
        System.out.print("\033[H\033[2J");
        for(int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                ColoredCharacter character = characterLocations.get(new Coordinate(x , y));
                if (character == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(character);
                }
            }
            System.out.print("\n");
        }
    }

    public static void main (String[] args) {
        Screen screen = new Screen(80, 30);
        BorderDecorator decorator2 = new BorderDecorator(screen, 1, new ColoredCharacter('*', Color.CYAN));
        BorderDecorator decorator = new BorderDecorator(decorator2, 2, new ColoredCharacter('#', Color.BLUE));
        decorator.draw(new Coordinate(5, 10), 'X', Color.WHITE);
        decorator.draw(new Coordinate(0, 0), 'A', Color.RED);
        screen.print();
    }
}

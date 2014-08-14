package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;
import com.sun.javafx.scene.layout.region.Border;
import jline.ConsoleReader;

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
        // Clears the console before each reprint.
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

    public static void main (String[] args) throws IOException {
        Screen screen = new Screen(80, 30);
        ScrollDecorator scrollDecorator = new ScrollDecorator(screen, 4, 4, 100, 100);
        BorderDecorator borderDecorator = new BorderDecorator(scrollDecorator, 1, new ColoredCharacter('*', Color.CYAN));
        borderDecorator.draw(new Coordinate(5, 10), 'X', Color.WHITE);
        borderDecorator.draw(new Coordinate(0, 0), 'A', Color.RED);
        screen.print();


        while(true) {
            int button = new ConsoleReader().readVirtualKey();

            switch (button) {
                case 2:
                    scrollDecorator.scrollRelative(0, -1);
                    break;
                case 14:
                    scrollDecorator.scrollRelative(1, 0);
                    break;
                case 6:
                    scrollDecorator.scrollRelative(0, 1);
                    break;
                case 16:
                    scrollDecorator.scrollRelative(-1, 0);
                    break;
                //default:
                  //  System.out.println((int)button);
                    //break;
            }

            screen.print();
        }

    }
}

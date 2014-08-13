package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roryolsen on 8/13/14.
 */
public class Screen {

    private Map<Coordinate, Character> characterLocations = new HashMap<>();
    private int width;
    private int height;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw (Coordinate coordinate, char character) {
        characterLocations.put(coordinate, character);
    }

    public void print() {
        for(int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                Character character = characterLocations.get(new Coordinate(x , y));
                if (character == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(character);
                }
            }
        }
    }
}

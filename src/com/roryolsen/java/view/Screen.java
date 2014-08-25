package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Board;
import com.roryolsen.java.model.BoardFactory;
import com.roryolsen.java.model.TerrainType;
import com.roryolsen.java.model.terrain.Palace;
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
        final Screen screen = new Screen(200, 40);
        RegionDecorator boardRegion = new RegionDecorator(screen, 0, 30, 170, 40);
        BorderDecorator boardBorderDecorator = new BorderDecorator(boardRegion, 1, new ColoredCharacter('*', Color.WHITE));
        ScrollDecorator boardScrollDecorator = new ScrollDecorator(boardBorderDecorator, 0, 0, 200, 100);
        Board board = new BoardFactory().createBoard();
        board.getSpace(new Coordinate(5,5)).setTopTerrainType(new Palace(5));
        final BoardRenderer boardRenderer = new BoardRenderer(board, boardScrollDecorator);

        new Thread() {
            @Override
            public void run() {
                while(true) {
                    boardRenderer.render();
                    screen.print();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        while(true) {
            int button = new ConsoleReader().readVirtualKey();

            switch (button) {
                case 2:
                    boardScrollDecorator.scrollRelative(0, -1);
                    break;
                case 14:
                    boardScrollDecorator.scrollRelative(1, 0);
                    break;
                case 6:
                    boardScrollDecorator.scrollRelative(0, 1);
                    break;
                case 16:
                    boardScrollDecorator.scrollRelative(-1, 0);
                    break;
            }
        }

    }
}

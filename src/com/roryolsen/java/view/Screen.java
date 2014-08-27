package com.roryolsen.java.view;

import com.roryolsen.java.controller.Controller;
import com.roryolsen.java.controller.TurnActionController;
import com.roryolsen.java.controller.render.BoardRenderer;
import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.core.Rotation;
import com.roryolsen.java.model.*;
import com.roryolsen.java.model.terrain.Palace;
import jline.ConsoleReader;

import java.io.IOException;
import java.util.ArrayList;
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

        final int SCREEN_WIDTH = 200;
        final int SCREEN_HEIGHT = 40;
        final int SPLIT_WIDTH = 50;

        final Screen screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
        RegionDecorator boardRegion = new RegionDecorator(screen, 0, SPLIT_WIDTH, SCREEN_WIDTH - SPLIT_WIDTH, SCREEN_HEIGHT);
        BorderDecorator boardBorderDecorator = new BorderDecorator(boardRegion, 1, new ColoredCharacter('*', Color.WHITE));
        ScrollDecorator boardScrollDecorator = new ScrollDecorator(boardBorderDecorator, 0, 0, 200, 100);
        Board board = new BoardFactory().createBoard();
        BoardSpace boardSpace = board.getSpace(new Coordinate(5, 5));
        boardSpace.setTopTerrainType(new Palace(5));
        Player playerOne = new Player();
        playerOne.setPlayerNumber(1);
        boardSpace.setPlayerWithDeveloperOnSpace(playerOne);
        boardSpace.setHeight(3);
        Game game = new Game(board, new ArrayList<Player>(), null, new ArrayList<GameTile>());
        RegionDecorator controllerRegionDecorator = new RegionDecorator(screen, 0, 0, SPLIT_WIDTH, SCREEN_HEIGHT);
        Controller turnActionController = new TurnActionController(game, controllerRegionDecorator);
        turnActionController.act();


        final BoardRenderer boardRenderer = new BoardRenderer(board, boardScrollDecorator);
        boardRenderer.setPotentialTilePlacement(new PotentialTilePlacement(new PalaceTile(3), new Coordinate(6,6), new Rotation(0)));

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
            PotentialTilePlacement currentPotentialTilePlacement = boardRenderer.getPotentialTilePlacement();

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
                case 'w':
                    boardRenderer.setPotentialTilePlacement(
                            new PotentialTilePlacement(
                                    currentPotentialTilePlacement.getGameTile(),
                                    currentPotentialTilePlacement.getLocation().plus(0, -1),
                                    currentPotentialTilePlacement.getRotation()
                            )
                    );
                    break;
                case 'a':
                    boardRenderer.setPotentialTilePlacement(
                            new PotentialTilePlacement(
                                    currentPotentialTilePlacement.getGameTile(),
                                    currentPotentialTilePlacement.getLocation().plus(-1, 0),
                                    currentPotentialTilePlacement.getRotation()
                            )
                    );
                    break;
                case 's':
                    boardRenderer.setPotentialTilePlacement(
                            new PotentialTilePlacement(
                                    currentPotentialTilePlacement.getGameTile(),
                                    currentPotentialTilePlacement.getLocation().plus(0, 1),
                                    currentPotentialTilePlacement.getRotation()
                            )
                    );
                    break;
                case 'd':
                    boardRenderer.setPotentialTilePlacement(
                            new PotentialTilePlacement(
                                    currentPotentialTilePlacement.getGameTile(),
                                    currentPotentialTilePlacement.getLocation().plus(1, 0),
                                    currentPotentialTilePlacement.getRotation()
                            )
                    );
                    break;
            }
        }
    }
}

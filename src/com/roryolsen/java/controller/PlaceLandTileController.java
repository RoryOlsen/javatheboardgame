package com.roryolsen.java.controller;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/26/14.
 */
public class PlaceLandTileController extends PanelController {

    public PlaceLandTileController(Game game, View view, GameController gameController) {
        super(game, view, gameController);
    }

    @Override
    public void actOnInput(int key) {
        switch (key) {
            case '1':
                break;
            case '2':
                break;
            case '3':
                break;

        }
    }

    @Override
    public void onActivate() {
        this.view.clear();
        final String text = "What type of tile would you like to place?\n" +
                "1. Single space land tile.\n" +
                "2. Double space land tile.\n" +
                "3. Triple space land tile.\n";

        this.view.draw(new Coordinate(0, 0), text, Color.RESET);

    }

    @Override
    public boolean acceptsInput(int key) {
        return false;
    }

    @Override
    public boolean acceptInputWhenNotActive() {
        return false;
    }
}

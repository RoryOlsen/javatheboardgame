package com.roryolsen.java.controller;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/26/14.
 */
public class PlaceLandTileController extends Controller {
    public PlaceLandTileController(Game game, View view) {
        super(game, view);
    }

    @Override
    public void act() {
        view.clear();
        view.draw(new Coordinate(0, 0), "Hi Mom!", Color.RESET);
    }
}

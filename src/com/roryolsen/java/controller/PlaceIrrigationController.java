package com.roryolsen.java.controller;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/26/14.
 */
public class PlaceIrrigationController extends PanelController {


    public PlaceIrrigationController(Game game, View view, GameController gameController) {
        super(game, view, gameController);
    }


    @Override
    public void actOnInput(int number) {

    }

    @Override
    public void onActivate() {
        this.view.clear();
        final String text = "Where would you like to place an irrigation tile?";
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

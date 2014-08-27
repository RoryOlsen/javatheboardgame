package com.roryolsen.java.controller;

import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/26/14.
 */
public class EndTurnController extends PanelController {

    protected EndTurnController(Game game, View view, GameController gameController) {
        super(game, view, gameController);
    }

    @Override
    public void actOnInput(int key) {

    }

    @Override
    public void onActivate() {

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

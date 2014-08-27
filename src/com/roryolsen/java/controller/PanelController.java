package com.roryolsen.java.controller;

import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/27/14.
 */
public abstract class PanelController extends Controller {

    protected final Game game;
    protected final View view;

    protected PanelController(Game game, View view, GameController gameController) {
        super(gameController);
        this.game = game;
        this.view = view;
    }
}

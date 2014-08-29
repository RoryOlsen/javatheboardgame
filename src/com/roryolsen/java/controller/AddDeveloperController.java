package com.roryolsen.java.controller;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/26/14.
 */
public class AddDeveloperController extends PanelController {

    public AddDeveloperController(Game game, View view, GameController gameController) {
        super(game, view, gameController);
    }

    @Override
    public void actOnInput(int key) {
        switch(key) {
            case '1':
                this.activate(new AddDeveloperFromLowlandsController(this.game, this.view, this.gameController));
                break;
            case '2':
                this.activate(new AddDeveloperFromMountainsController(this.game, this.view, this.gameController));
                break;

        }
    }

    @Override
    public void onActivate() {
        this.view.clear();
        final String text = "From where are you placing the developer?\n" +
                "1. Mountains.\n" +
                "2. Lowlands.\n";

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

    private class AddDeveloperFromLowlandsController extends PanelController {
        public AddDeveloperFromLowlandsController(Game game, View view, GameController gameController) {
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

    private class AddDeveloperFromMountainsController extends PanelController {
        public AddDeveloperFromMountainsController(Game game, View view, GameController gameController) {
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
}

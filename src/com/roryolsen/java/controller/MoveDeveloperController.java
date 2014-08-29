package com.roryolsen.java.controller;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by roryolsen on 8/26/14.
 */
public class MoveDeveloperController extends PanelController {

    public MoveDeveloperController(Game game, View view, GameController gameController) {
        super(game, view, gameController);
    }

    @Override
    public void actOnInput(int key) {
        switch (key) {
            case 9:
                this.activate(new CyclePlayerDevelopersController(this.game, this.view, this.gameController));
                break;
        }


    }

    @Override
    public void onActivate() {
        this.view.clear();
        final String text = "Cycle through your developers with the TAB key.";
        this.view.draw(new Coordinate(0, 0), text, Color.RESET);

    }


    @Override
    public boolean acceptsInput(int key) {
        Set<Integer> acceptedKeys = new HashSet<>();
        int[] accepted = {9};
        for (int acceptedKey : accepted) {
            acceptedKeys.add(acceptedKey);
        }
        return acceptedKeys.contains(key);
    }

    @Override
    public boolean acceptInputWhenNotActive() {
        return false;
    }

    private class CyclePlayerDevelopersController extends PanelController {
        public CyclePlayerDevelopersController(Game game, View view, GameController gameController) {
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
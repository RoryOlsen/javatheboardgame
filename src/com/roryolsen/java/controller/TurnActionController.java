package com.roryolsen.java.controller;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by roryolsen on 8/26/14.
 */
public class TurnActionController extends PanelController {


    protected TurnActionController(Game game, View view, GameController gameController) {
        super(game, view, gameController);
    }

    @Override
    public void actOnInput(int key) {

    }

    @Override
    public void onActivate() {
        final String text = "What do you want to do?\n" +
                "1. PLace a land tile.\n" +
                "2. Add a developer to Central Java.\n" +
                "3. Move a developer.\n" +
                "4. Build a palace.\n" +
                "5. Enlarge a palace.\n" +
                "6. Place an irrigation tile.\n" +
                "7. Draw a palace card.\n" +
                "8. Arrange a palace festival.\n" +
                "9. I\'m out of action point! / I\'m done!";

        this.view.draw(new Coordinate(0, 0), text, Color.RESET);

    }

    @Override
    public boolean acceptsInput(int key) {
        Set<Integer> acceptedKeys = new HashSet<>();
        int[] accepted = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(int acceptedKey: accepted) {
            acceptedKeys.add(acceptedKey);
        }
        return acceptedKeys.contains(key);
    }

    @Override
    public boolean acceptInputWhenNotActive() {
        return false;
    }

}



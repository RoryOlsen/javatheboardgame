package com.roryolsen.java.controller;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/26/14.
 */
public class TurnActionController extends Controller{

    public TurnActionController(Game game, View view) {
        super(game, view);

    }

    @Override
    public void act() {
        view.clear();
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

        view.draw(new Coordinate(0,0), text, Color.RESET);

        int button = readKey();

        switch(button) {
            case '1':
                new PlaceLandTileController(game, view).act();
                break;
        }
    }


}

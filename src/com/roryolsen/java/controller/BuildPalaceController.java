package com.roryolsen.java.controller;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/26/14.
 */
public class BuildPalaceController extends PanelController {

    public BuildPalaceController(Game game, View view, GameController gameController) {
        super(game, view, gameController);
    }

    @Override
    public void actOnInput(int key) {
        switch (key) {
            // Size 2 palace
            case 1:
                this.activate(new AddPalaceController(2, this.game, this.view, this.gameController));
                break;
            // Size 4 palace
            case 2:
                this.activate(new AddPalaceController(4, this.game, this.view, this.gameController));
                break;
            // Size 6 palace
            case 3:
                this.activate(new AddPalaceController(6, this.game, this.view, this.gameController));
                break;
            // Size 8 palace
            case 4:
                this.activate(new AddPalaceController(8, this.game, this.view, this.gameController));
                break;
            // Size 10 palace
            case 5:
                this.activate(new AddPalaceController(10,this.game, this.view, this.gameController));
                break;
        }

    }

    @Override
    public void onActivate() {
            this.view.clear();
            final String text = "What size palace would you like to place?\n" +
                    "1. 2\n" +
                    "2. 4\n" +
                    "3. 6\n" +
                    "4. 8\n" +
                    "5. 10\n";

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

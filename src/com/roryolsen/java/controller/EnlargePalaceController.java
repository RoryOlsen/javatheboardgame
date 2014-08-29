package com.roryolsen.java.controller;

import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.View;

/**
 * Created by roryolsen on 8/26/14.
 */
public class EnlargePalaceController extends PanelController {

    public EnlargePalaceController(Game game, View view, GameController gameController) {
        super(game, view, gameController);
    }

    @Override
    public void actOnInput(int key) {
        switch (key) {
            case 1:
                this.activate(new AddPalaceController(4, this.game, this.view, this.gameController));
                break;
            case 2:
                this.activate(new AddPalaceController(6, this.game, this.view, this.gameController));
                break;
            case 3:
                this.activate(new AddPalaceController(8,this.game, this.view, this.gameController));
                break;
            case 4:
                this.activate(new AddPalaceController(10,this.game, this.view, this.gameController));
                break;
        }

    }

    @Override
    public void onActivate() {
        view.clear();
        final String text = "TO what size would you like to upgrade the palace?\n" +
                "1. 4\n" +
                "2. 6\n" +
                "3. 8\n" +
                "4. 10\n";

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

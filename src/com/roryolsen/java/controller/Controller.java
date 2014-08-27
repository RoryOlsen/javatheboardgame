package com.roryolsen.java.controller;

import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.View;
import jline.ConsoleReader;

import java.io.IOException;

/**
 * Created by roryolsen on 8/26/14.
 */
public abstract class Controller {

    private final GameController gameController;

    protected Controller(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract void actOnInput(int key);

    public abstract void onActivate();

    public abstract boolean acceptsInput(int key);

    public abstract boolean acceptInputWhenNotActive();

    public void activate(Controller controller) {
        gameController.activateController(controller);
    }

    public void deactivate() {
        gameController.deactivateController(this);
    }

}

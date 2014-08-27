package com.roryolsen.java.controller;

import com.roryolsen.java.model.Game;
import com.roryolsen.java.view.View;
import jline.ConsoleReader;

import java.io.IOException;

/**
 * Created by roryolsen on 8/26/14.
 */
public abstract class Controller {

    protected final Game game;
    protected final View view;

    protected Controller(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    public abstract void act();

    public int readKey() {
        try {
            return new ConsoleReader().readVirtualKey();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

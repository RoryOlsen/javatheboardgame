package com.roryolsen.java.controller;

/**
 * Created by roryolsen on 8/28/14.
 */
public class BoardController extends Controller {

    protected BoardController(GameController gameController) {
        super(gameController);
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

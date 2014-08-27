package com.roryolsen.java.controller;

import jline.ConsoleReader;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by roryolsen on 8/27/14.
 */
public class GameController {

    private final LinkedList<Controller> controllers = new LinkedList<>();

    public void activateController(Controller controller) {
        controllers.addFirst(controller);
        controller.onActivate();
    }

    public void deactivateController(Controller controller) {
        controllers.remove(controller);
        controllers.getFirst().onActivate();

    }

    public void start() {
        ConsoleReader consoleReader;
        try {
            consoleReader = new ConsoleReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(true) {
            int key;
            try {
                key = consoleReader.readVirtualKey();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for(Controller controller : controllers) {
                if(controller.acceptsInput(key)) {
                    if(controllers.indexOf(controller) == 0 || controller.acceptInputWhenNotActive()) {
                            controller.actOnInput(key);
                            break;
                    }
                }
            }
        }
    }
}

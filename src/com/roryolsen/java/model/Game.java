package com.roryolsen.java.model;

import java.util.List;

/**
 * Created by roryolsen on 8/14/14.
 */
public class Game {

    private final Board board;
    private final List<Player> players;
    private final List<GameTile> unusedGameTiles;
    private Turn currentTurn;

    private Game(Board board, List<Player> players, Turn currentTurn, List<GameTile> unusedGameTiles) {
        this.board = board;
        this.players = players;
        this.currentTurn = currentTurn;
        this.unusedGameTiles = unusedGameTiles;
    }
}

package com.roryolsen.java.model;

import java.util.List;

/**
 * Created by roryolsen on 8/14/14.
 */
public class Game {

    private Board board;
    private List<Player> players;
    private Turn currentTurn;
    private List<GameTile> unusedGameTiles;

    private Game(Board board, List<Player> players, Turn currentTurn, List<GameTile> unusedGameTiles) {
        this.board = board;
        this.players = players;
        this.currentTurn = currentTurn;
        this.unusedGameTiles = unusedGameTiles;
    }
}

package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;

import java.util.Map;

/**
 * Created by roryolsen on 8/19/14.
 */
public class BoardFactory {

    public Board createBoard() {
        Board board = new Board();
        Map<Coordinate, BoardSpace> boardSpaces = board.getBoardSpaces();
        for(int x = 0; x < 14; x++) {
            for(int y = 0; y < 14; y++) {
                // Extra spaces around board
                if(y == 0 || x == 0 || x == 13 || y == 13) {
                    boardSpaces.put(new Coordinate(x, y), new BoardSpace(BorderStatus.NOT_BORDER, true));
                }
                // Spaces on board bordering mountains
                if((y == 1 && x > 6) || (x== 1 && y > 6) || (x == 12 && y < 7) || (y == 12 && x < 7)) {
                    boardSpaces.put(new Coordinate(x, y), new BoardSpace(BorderStatus.MOUNTAIN_BORDER, false));
                }
                // Spaces on board bordering lowlands
                if((y == 1 && x < 7) || (x == 1 && y < 7) || (x == 12 && y > 6) || (y == 12 && x > 6)) {
                    boardSpaces.put(new Coordinate(x, y), new BoardSpace(BorderStatus.LOWLANDS_BORDER, false));
                // All other spaces on the board
                } else {
                  boardSpaces.put(new Coordinate(x, y), new BoardSpace(BorderStatus.NOT_BORDER, false));
                }
            }
        }
        return board;
    }
}

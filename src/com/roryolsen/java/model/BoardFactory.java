package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;

/**
 * Created by roryolsen on 8/19/14.
 */
public class BoardFactory {

    public Board createBoard() {
        int width = 14;
        int height = 14;
        int halfWidth = width/2;
        int halfHeight = height/2;
        Board board = new Board();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < width; y++) {
                // Extra spaces around board
                if(y == 0 || x == 0 || x == width - 1 || y == width - 1) {
                    board.setSpace(new Coordinate(x, y), new BoardSpace(BorderStatus.NOT_BORDER, true));
                } else if ((y == 1 && x >= halfWidth) ||
                        (x== 1 && y > halfHeight) ||
                        (x == width - 2 && y < halfHeight) || (y == height - 2 && x < halfWidth)) {
                    // Spaces on board bordering mountains
                    board.setSpace(new Coordinate(x, y), new BoardSpace(BorderStatus.MOUNTAIN_BORDER, false));
                } else if((y == 1 && x < halfWidth) ||
                        (x == 1 && y < halfHeight) ||
                        (x == width - 2 && y >= halfHeight) || (y == width - 2 && x >= halfWidth )) {
                    // Spaces on board bordering lowlands
                    board.setSpace(new Coordinate(x, y), new BoardSpace(BorderStatus.LOWLANDS_BORDER, false));
                } else {
                    // All other spaces on the board
                    board.setSpace(new Coordinate(x, y), new BoardSpace(BorderStatus.NOT_BORDER, false));
                }
            }
        }
        return board;
    }
}

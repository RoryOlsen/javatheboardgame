package com.roryolsen.java.view;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.Board;
import com.roryolsen.java.model.BoardSpace;
import com.roryolsen.java.model.TerrainType;
import com.roryolsen.java.model.terrain.Irrigation;
import com.roryolsen.java.model.terrain.Palace;
import com.roryolsen.java.model.terrain.RiceField;
import com.roryolsen.java.model.terrain.Village;

import java.util.Map;

/**
 * Created by roryolsen on 8/25/14.
 */
public class BoardRenderer {

    private final Board board;
    private final View view;

    public BoardRenderer(Board board, View view) {
        this.board = board;
        this.view = view;
    }

    public void render() {
        for(Map.Entry<Coordinate, BoardSpace> entry : board.getBoardSpaces().entrySet()) {
            Coordinate boardCoordinate = entry.getKey();
            Coordinate viewCoordinate = new Coordinate(boardCoordinate.getX() * 9, boardCoordinate.getY() * 4);
            drawBoardSpace(entry.getValue(), viewCoordinate);
        }
    }

    public void drawBoardSpace(BoardSpace boardSpace, Coordinate coordinate) {
        final char corner = '+';
        final char horizontalEdge = '-';
        final char verticalEdge = '|';
        final TerrainType terrainType = boardSpace.getTopTerrainType();
        final Color borderColor = Color.RESET;
        final String terrainTypeIndicator;

        // Top, left corner
        view.draw(coordinate, corner, borderColor);

        // Top border
        for(int i = 0; i < 8; i++) {
            view.draw(coordinate.plus((i+1), 0), horizontalEdge, borderColor);
        }

        // Top, right corner
        view.draw(coordinate.plus(9, 0), corner, borderColor);

        // Left border
        for(int i = 0; i < 3; i++) {
            view.draw(coordinate.plus(0, i + 1), verticalEdge, borderColor);
        }

        // Right border
        for(int i = 0; i < 3; i++) {
            view.draw(coordinate.plus(9, i + 1), verticalEdge, borderColor);
        }

        // Bottom border
        for(int i = 0; i < 8; i++) {
            view.draw(coordinate.plus(i + 1, 4), horizontalEdge, borderColor);
        }

        if(terrainType != null) {
            if(terrainType instanceof Palace) {
                terrainTypeIndicator = "P" + ((Palace) terrainType).getValue();
            } else if(terrainType instanceof Irrigation) {
                terrainTypeIndicator = "IR";
            } else if(terrainType instanceof RiceField) {
                terrainTypeIndicator = "RF";
            } else if(terrainType instanceof Village) {
                terrainTypeIndicator = "VI";
            } else {
                throw new IllegalStateException("Unknown Terrain Type " + terrainType.getClass().getName());
            }
            view.draw(coordinate.plus(2, 1), terrainTypeIndicator, Color.RESET);
        }

    }
}

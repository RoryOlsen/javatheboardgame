package com.roryolsen.java.controller.render;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.model.*;
import com.roryolsen.java.model.terrain.Irrigation;
import com.roryolsen.java.model.terrain.Palace;
import com.roryolsen.java.model.terrain.RiceField;
import com.roryolsen.java.model.terrain.Village;
import com.roryolsen.java.view.Color;
import com.roryolsen.java.view.View;

import java.util.Map;

/**
 * Created by roryolsen on 8/25/14.
 */
public class BoardRenderer {

    private final Board board;
    private final View view;
    private PotentialTilePlacement potentialTilePlacement;

    public BoardRenderer(Board board, View view) {
        this.board = board;
        this.view = view;
    }

    public PotentialTilePlacement getPotentialTilePlacement() {
        return potentialTilePlacement;
    }

    public void setPotentialTilePlacement(PotentialTilePlacement potentialTilePlacement) {
        this.potentialTilePlacement = potentialTilePlacement;
    }

    private Coordinate translateFromBoardToView(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() * 9, coordinate.getY() * 4);
    }

    public void render() {
        for (Map.Entry<Coordinate, BoardSpace> entry : board.getBoardSpaces().entrySet()) {
            Coordinate boardCoordinate = entry.getKey();
            Coordinate viewCoordinate = translateFromBoardToView(boardCoordinate);
            drawBoardSpace(entry.getValue(), viewCoordinate);
        }
        if(potentialTilePlacement != null) {
            drawPotentialTilePlacement();
        }
    }

    private void drawBoardSpaceBorder(Coordinate coordinate, Color borderColor) {
        final char corner = '+';
        final char horizontalEdge = '-';
        final char verticalEdge = '|';

        // Top, left corner
        view.draw(coordinate, corner, borderColor);

        // Top, right corner
        view.draw(coordinate.plus(9, 0), corner, borderColor);

        //Bottom, left corner
        view.draw(coordinate.plus(0, 4), corner, borderColor);

        //Bottom, right corner
        view.draw(coordinate.plus(9, 4), corner, borderColor);

        // Top border
        for (int i = 0; i < 8; i++) {
            view.draw(coordinate.plus((i + 1), 0), horizontalEdge, borderColor);
        }

        // Left border
        for (int i = 0; i < 3; i++) {
            view.draw(coordinate.plus(0, i + 1), verticalEdge, borderColor);
        }

        // Right border
        for (int i = 0; i < 3; i++) {
            view.draw(coordinate.plus(9, i + 1), verticalEdge, borderColor);
        }

        // Bottom border
        for (int i = 0; i < 8; i++) {
            view.draw(coordinate.plus(i + 1, 4), horizontalEdge, borderColor);
        }
    }

    private void drawBoardSpace(BoardSpace boardSpace, Coordinate coordinate) {

        this.drawBoardSpaceBorder(coordinate, Color.RESET);

        final TerrainType terrainType = boardSpace.getTopTerrainType();
        final String terrainTypeIndicator;

        //TODO: Implement Visitor Design Pattern
        if (terrainType != null) {
            if (terrainType instanceof Palace) {
                terrainTypeIndicator = "P" + ((Palace) terrainType).getValue();
            } else if (terrainType instanceof Irrigation) {
                terrainTypeIndicator = "IR";
            } else if (terrainType instanceof RiceField) {
                terrainTypeIndicator = "RF";
            } else if (terrainType instanceof Village) {
                terrainTypeIndicator = "VI";
            } else {
                throw new IllegalStateException("Unknown Terrain Type " + terrainType.getClass().getName());
            }
            view.draw(coordinate.plus(2, 1), terrainTypeIndicator, Color.RESET);
        }

        if (boardSpace.getPlayerWithDeveloperOnSpace() != null) {
            view.draw(coordinate.plus(6, 1), "D" + boardSpace.getPlayerWithDeveloperOnSpace().getPlayerNumber(), Color.RESET);
        }
        if (boardSpace.getTopTerrainType() != null) {
            view.draw(coordinate.plus(3, 3), "H:" + boardSpace.getHeight(), Color.RESET);
        }
    }

    private void drawPotentialTilePlacement() {
        Map<Coordinate, TerrainType> gameTileStructure = potentialTilePlacement.getGameTile().getTerrainTypeLocations();

        for (Map.Entry<Coordinate, TerrainType> entry : gameTileStructure.entrySet()) {
            Coordinate rotatedCoordinate = potentialTilePlacement.getRotation().rotateClockwise(entry.getKey());
            Coordinate currentCoordinate = potentialTilePlacement.getLocation().plus(rotatedCoordinate);
            Coordinate viewCoordinate = translateFromBoardToView(currentCoordinate);
            drawBoardSpaceBorder(viewCoordinate, Color.YELLOW);
        }
    }
}

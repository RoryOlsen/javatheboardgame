package com.roryolsen.java.model;

import com.roryolsen.java.core.Coordinate;
import com.roryolsen.java.core.Rotation;

import java.util.Map;

/**
 * Created by roryolsen on 8/14/14.
 */
public class Turn {

    private int actionPoints;
    private Board board;
    private Player player;
    private boolean usedExtraAction;
    private PotentialTilePlacement potentialTilePlacement;

    public void placeGameTile(GameTile gameTile, Coordinate coordinate, Rotation rotation) {
        Map<Coordinate,TerrainType> gameTileStructure = gameTile.getTerrainTypeLocations();
        for(Map.Entry<Coordinate, TerrainType> entry: gameTileStructure.entrySet()) {
            // The transformed board space from the origin space for tiles that are larger than 1 space
            Coordinate rotatedCoordinate = rotation.rotateClockwise(entry.getKey());
            Coordinate currentCoordinate = coordinate.plus(rotatedCoordinate);
            BoardSpace boardSpace = board.getSpace(currentCoordinate);
            boardSpace.setTopTerrainType(entry.getValue());
            boardSpace.setHeight(boardSpace.getHeight() + 1);
        }

    }

    public void placeDeveloper(BoardSpace boardSpace) {
        if (player.getDevelopersOnBoard() == 12) {
            throw new UnsupportedOperationException();
        } else {
            player.setDevelopersOnBoard(player.getDevelopersOnBoard() + 1);
            if(boardSpace.getPlayerWithDeveloperOnSpace() == null) {
                boardSpace.setPlayerWithDeveloperOnSpace(player);
            } else {
                throw new UnsupportedOperationException();
            }

        }
    }

    public void moveDeveloper(BoardSpace start, BoardSpace end) {
        end.setPlayerWithDeveloperOnSpace(player);
        start.setPlayerWithDeveloperOnSpace(null);

    }

    public void upgradePalace(PalaceTile palaceTile, int value) {
        palaceTile.setValue(value);
    }

    public void useExtraActionToken() {
        if(!usedExtraAction) {
            this.actionPoints++;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void updateScore(int score) {
        player.setScore(score);
    }
}

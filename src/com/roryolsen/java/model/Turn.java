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

    //Rotations are not supported yet. Are rotations being measured in units or degrees?
    public void placeGameTile(GameTile gameTile, Coordinate coordinate, Rotation rotation) {
        Map<Coordinate,TerrainType> gameTileStructure = gameTile.getTerrainTypeLocations();
        for(Map.Entry<Coordinate, TerrainType> entry: gameTileStructure.entrySet()) {
            // The transformed board space from the origin space for tiles that are larger than 1 space
            BoardSpace boardSpace = board.getSpace(new Coordinate(coordinate.getX() + entry.getKey().getX(),
                    coordinate.getY() + entry.getKey().getY()));
            boardSpace.setTopTerrainType(entry.getValue());
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

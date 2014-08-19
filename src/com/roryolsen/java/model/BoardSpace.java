package com.roryolsen.java.model;

/**
 * Created by roryolsen on 8/14/14.
 */
public class BoardSpace {

    private GameTile topTerrainType;
    private Player playerDeveloper;
    private int height;
    private final BorderStatus borderStatus;
    private final boolean isExtraSpace;

    public BoardSpace(BorderStatus borderStatus, boolean isExtraSpace) {
        this.borderStatus = borderStatus;
        this.isExtraSpace = isExtraSpace;
    }

    public GameTile getTopTerrainType() {
        return topTerrainType;
    }

    public void setTopTerrainType(GameTile topTerrainType) {
        this.topTerrainType = topTerrainType;
    }

    public Player getPlayerDeveloper() {
        return playerDeveloper;
    }

    public void setPlayerDeveloper(Player playerDeveloper) {
        this.playerDeveloper = playerDeveloper;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

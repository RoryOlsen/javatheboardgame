package com.roryolsen.java.model;

/**
 * Created by roryolsen on 8/14/14.
 */
public class Player {

    private int score;
    private int playerNumber;
    private int extraActionTokens;
    private int developersOnBoard;
    private int oneSpaceLandTilesRemaining;
    private int twoSpaceLandTilesRemaining;

    public void placeGameTile(GameTile gameTile) {
        throw new UnsupportedOperationException();
    }

    public void placeDeveloper() {
        throw new UnsupportedOperationException();
    }

    public void moveDeveloper() {
        throw new UnsupportedOperationException();
    }

    public void upgradePalace() {
        throw new UnsupportedOperationException();
    }

    public void useExtraActionToken() {
        throw new UnsupportedOperationException();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getExtraActionTokens() {
        return extraActionTokens;
    }

    public void setExtraActionTokens(int extraActionTokens) {
        this.extraActionTokens = extraActionTokens;
    }

    public int getDevelopersOnBoard() {
        return developersOnBoard;
    }

    public void setDevelopersOnBoard(int developersOnBoard) {
        this.developersOnBoard = developersOnBoard;
    }

    public int getOneSpaceLandTilesRemaining() {
        return oneSpaceLandTilesRemaining;
    }

    public void setOneSpaceLandTilesRemaining(int oneSpaceLandTilesRemaining) {
        this.oneSpaceLandTilesRemaining = oneSpaceLandTilesRemaining;
    }

    public int getTwoSpaceLandTilesRemaining() {
        return twoSpaceLandTilesRemaining;
    }

    public void setTwoSpaceLandTilesRemaining(int twoSpaceLandTilesRemaining) {
        this.twoSpaceLandTilesRemaining = twoSpaceLandTilesRemaining;
    }
}

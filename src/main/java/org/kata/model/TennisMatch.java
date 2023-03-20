package org.kata.model;

import static java.lang.System.*;
import static org.kata.model.StatusEnum.*;

public class TennisMatch implements Match {
    public static final String PLAYER_A = "Player A";
    public static final String PLAYER_B = "Player B";
    public static final char TAG_A = 'A';
    public static final char TAG_B = 'B';
    private final Player player1;
    private final Player player2;
    private final String gameInput;

    private StatusEnum gameStatus;

    public TennisMatch(String gameInput) {
        this.player1 = new Player(PLAYER_A, TAG_A);
        this.player2 = new Player(PLAYER_B, TAG_B);
        this.gameInput = gameInput;
        gameStatus = NO_WIN;
    }

    @Override
    public Player play() {
        for (int i = 0; i < gameInput.length(); i++) {
            char winningBall = gameInput.charAt(i);
            player1.playBall(winningBall, gameStatus);
            player2.playBall(winningBall, gameStatus);
            updateGameStatus();
            displayGame();
        }
        return getWinner();
    }

    private void updateGameStatus() {
        this.gameStatus = checkGameStatus();
    }

    private boolean isDeuce() {
        return player1.getLastPoint() == PointEnum.FORTY && player1.getLastPoint() == player2.getLastPoint();
    }
    private boolean isAdvantage() {
        return player1.getLastPoint() == PointEnum.ADVANTAGE || player2.getLastPoint() == PointEnum.ADVANTAGE;
    }

    private StatusEnum checkGameStatus() {
        if (isDeuce()) {
            return DEUCE;
        }
        if (isAdvantage()) {
            return ADVANTAGE;
        }
        if (hasWinner()) {
            return WIN;
        }
        return NO_WIN;
    }

    private void displayGame() {
        if (hasWinner()) {
            out.println(getWinner().getName() + " wins the game");
        } else {
            out.println(player1.getName() + " : " + player1.getLastPoint().getPointValue() + " / " + player2.getName() + " : " + player2.getLastPoint().getPointValue());
            if (gameStatus == DEUCE) {
                out.println(DEUCE);
            }
        }
    }

    private Player getWinner() {
        return player1.getLastPoint() == PointEnum.WIN ? player1 : player2;
    }

    private boolean hasWinner() {
        return player1.getLastPoint() == PointEnum.WIN || player2.getLastPoint() == PointEnum.WIN;
    }

}

package org.kata.model;

public class TennisMatch implements Match {
    public static final String PLAYER_A = "Player A";
    public static final String PLAYER_B = "Player B";
    private Player player1;
    private Player player2;
    private final String gameInput;

    private boolean isDeuced;

    public TennisMatch(String gameInput) {
        this.player1 = new Player(PLAYER_A);
        this.player2 = new Player(PLAYER_B);
        this.gameInput = gameInput;
        this.isDeuced = false;
    }

    @Override
    public Player play() {
        for (int i = 0; i<gameInput.length(); i++) {
            char ball = gameInput.charAt(i);
            if (ball == 'A') {
                player1.winBall(isDeuced);
            } else {
                player2.winBall(isDeuced);
            }
        }
        return getWinner();
    }

    private Player getWinner() {
        return player1.getLastPoint() == PointEnum.WIN ? player1 : player2;
    }

}

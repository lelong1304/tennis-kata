package org.kata.model;

public class TennisMatch implements Match {
    public static final String PLAYER_A = "Player A";
    public static final String PLAYER_B = "Player B";
    private Player player1;
    private Player player2;
    private final String gameInput;

    public TennisMatch(String gameInput) {
        this.player1 = new Player(PLAYER_A);
        this.player2 = new Player(PLAYER_B);
        this.gameInput = gameInput;
    }

    @Override
    public Player play() {
        return null;
    }

}

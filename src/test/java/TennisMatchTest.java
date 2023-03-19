import org.junit.jupiter.api.Test;
import org.kata.model.Player;
import org.kata.model.TennisMatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TennisMatchTest {

    public static final String PLAYER_A = "Player A";
    public static final String PLAYER_B = "Player B";

    @Test
    void should_player1_win_without_deuce() {
        String gameInputString = "ABABAA";
        TennisMatch match = new TennisMatch(gameInputString);

        Player winner = match.play();

        assertEquals(PLAYER_A, winner.getName());
    }

    @Test
    void should_player2_win_without_deuce() {
    String gameInputString = "BABBAB";
        TennisMatch match = new TennisMatch(gameInputString);

        Player winner = match.play();

        assertEquals(PLAYER_B, winner.getName());
    }

    @Test
    void should_player1_win_with_advantage() {
        String gameInputString = "ABABABBAAA";
        TennisMatch match = new TennisMatch(gameInputString);

        Player winner = match.play();

        assertEquals(PLAYER_A, winner.getName());
        assertNotEquals(PLAYER_B, winner.getName());
    }

    @Test
    void should_player2_win_with_advantage() {
        String gameInputString = "ABABABBAABBB";
        TennisMatch match = new TennisMatch(gameInputString);

        Player winner = match.play();

        assertEquals(PLAYER_B, winner.getName());
    }

}

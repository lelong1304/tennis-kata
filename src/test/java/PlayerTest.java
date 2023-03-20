import org.junit.jupiter.api.Test;
import org.kata.model.Player;
import org.kata.model.PointEnum;
import org.kata.model.StatusEnum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.kata.model.PointEnum.*;
import static org.kata.model.StatusEnum.DEUCE;
import static org.kata.model.StatusEnum.NO_WIN;

class PlayerTest {
    @Test
    void should_get_last_point_is_zero() {
        Player player = new Player("Long LE", 'A');

        PointEnum lastPoint = player.getLastPoint();

        assertEquals(ZERO, lastPoint);
    }

    @Test
    void should_get_last_point() {
        Player player = new Player("Long LE", 'A');
        player.getPoints().add(ZERO);
        player.getPoints().add(FIFTEEN);

        PointEnum lastPoint = player.getLastPoint();

        assertEquals(FIFTEEN, lastPoint);
    }

    @Test
    void should_play_ball_when_is_winning_ball_and_game_is_no_win() {
        char tag = 'A';
        Player player = new Player("Long LE", tag);
        player.getPoints().add(ZERO);
        player.getPoints().add(FIFTEEN);

        player.playBall(tag, NO_WIN);

        assertEquals(THIRTY, player.getLastPoint());
    }

    @Test
    void should_play_ball_when_is_winning_ball_and_game_is_deuce() {
        char tag = 'A';
        Player player = new Player("Long LE", tag);
        player.getPoints().add(ZERO);
        player.getPoints().add(FIFTEEN);
        player.getPoints().add(THIRTY);
        player.getPoints().add(FORTY);

        player.playBall(tag, DEUCE);

        assertEquals(ADVANTAGE, player.getLastPoint());
    }

    @Test
    void should_win_game_when_is_winning_ball_and_game_is_advantage() {
        char tag = 'A';
        Player player = new Player("Long LE", tag);
        player.getPoints().add(ZERO);
        player.getPoints().add(FIFTEEN);
        player.getPoints().add(THIRTY);
        player.getPoints().add(FORTY);
        player.getPoints().add(ADVANTAGE);

        player.playBall(tag, StatusEnum.ADVANTAGE);

        assertEquals(WIN, player.getLastPoint());
    }

    @Test
    void should_lost_advantage_when_not_winning_ball_and_game_is_advantage_for_another_player() {
        char tag = 'A';
        Player player = new Player("Long LE", tag);
        player.getPoints().add(ZERO);
        player.getPoints().add(FIFTEEN);
        player.getPoints().add(THIRTY);
        player.getPoints().add(FORTY);
        player.getPoints().add(ADVANTAGE);

        player.playBall('B', StatusEnum.ADVANTAGE);

        assertEquals(FORTY, player.getLastPoint());
    }

}

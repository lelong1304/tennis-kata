import org.junit.jupiter.api.Test;
import org.kata.model.Player;
import org.kata.model.PointEnum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.kata.model.PointEnum.ZERO;

class PlayerTest {
    @Test
    void should_get_last_point_is_zero() {
        Player player = new Player("Long LE", 'A');

        PointEnum lastPoint = player.getLastPoint();

        assertEquals(ZERO, lastPoint);
    }

}

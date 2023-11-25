import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PowerTest {
    private Arena arena;
    private SpaceShip spaceShip;

    @BeforeEach
    void setUp() {
        arena = new Arena(100, 50);
        spaceShip = new SpaceShip(10, 10);
    }

    @Test
    void checkRetrieve() {
        Power power = new Power(spaceShip.getX(), spaceShip.getY());
        arena.getPowers().add(power);
        arena.setSpaceShipPosition(spaceShip.getX(), spaceShip.getY());
        int originalSize = arena.getPowers().size();
        arena.retrievePowers();
        Assertions.assertEquals(originalSize - 1, arena.getPowers().size());
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpaceShipTest {
    private SpaceShip spaceShip;

    @BeforeEach
    void setUp() {
        spaceShip = new SpaceShip(10, 2);
    }

    @Test
    void moveUpSpaceShip() {
        Position initialPosition = spaceShip.getPosition();
        Position newPosition = spaceShip.moveUp();
        Assertions.assertEquals(initialPosition.moveUp(), newPosition);
    }

    @Test
    void moveDownSpaceShip() {
        Position initialPosition = spaceShip.getPosition();
        Position newPosition = spaceShip.moveDown();
        Assertions.assertEquals(initialPosition.moveDown(), newPosition);
    }

    @Test
    void moveLeftSpaceShip() {
        Position initialPosition = spaceShip.getPosition();
        Position newPosition = spaceShip.moveLeft();
        Assertions.assertEquals(initialPosition.moveLeft(), newPosition);
    }

    @Test
    void moveRightSpaceShip() {
        Position initialPosition = spaceShip.getPosition();
        Position newPosition = spaceShip.moveRight();
        Assertions.assertEquals(initialPosition.moveRight(), newPosition);
    }
}

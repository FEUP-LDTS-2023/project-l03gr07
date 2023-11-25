import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollisionTest {
    private Arena arena;
    private Meteor meteor;
    private SpaceShip spaceShip;

    @BeforeEach
    public void setUp() {
        this.arena = new Arena(100, 50);
        this.meteor = new Meteor(10, 3);
        this.spaceShip = new SpaceShip(10, 2);
    }

    @Test
    public void checkCollision() {
        this.arena.moveSpaceShip(spaceShip.getPosition());
        this.arena.getMeteors().add(meteor);
        this.arena.verifyCollisions();
        Assertions.assertFalse(arena.getRunning(), "Collision failed.");
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MeteorTest {
    private Meteor meteor;

    @BeforeEach
    void setUp() {
        meteor = new Meteor(10,1);
    }

    @Test
    void moveMeteor() {
        Position newPosition = meteor.move();
        Assertions.assertEquals(2, newPosition.getY());
    }
}

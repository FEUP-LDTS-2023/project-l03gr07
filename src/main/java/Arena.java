import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Arena {
    private int height;
    private int width;
    private SpaceShip spaceShip;
    private List<Meteor> meteors;
    private List<Power> powers;
    private boolean running = true;

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        spaceShip = new SpaceShip(width/2, height/2);
        this.meteors = createMeteors();
        this.powers = createPowers();
    }

    public boolean getRunning() {return running; }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()){
            case Character:
                running = key.getCharacter() != 'q';
                break;

            case ArrowUp:
                moveSpaceShip(spaceShip.moveUp());
                break;

            case ArrowDown:
                moveSpaceShip(spaceShip.moveDown());
                break;

            case ArrowLeft:
                moveSpaceShip(spaceShip.moveLeft());
                break;

            case ArrowRight:
                moveSpaceShip(spaceShip.moveRight());
                break;
        }
    }

    public void draw (TextGraphics graphics) {
        verifyCollisions();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        retrievePowers();
        for (Power power : powers)
            power.draw(graphics);
        for (Meteor meteor : meteors)
            meteor.draw(graphics);
        spaceShip.draw(graphics);
        moveMeteors();
    }

    public void moveSpaceShip(Position position) {
        spaceShip.setPosition(position);
    }

    public void setSpaceShipPosition(int x, int y) {
        spaceShip.setPosition(new Position(x, y));
    }

    private List<Meteor> createMeteors() {
        Random random = new Random();
        ArrayList<Meteor> meteors = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            meteors.add(new Meteor(random.nextInt(width - 2) + 1, -1));
        return meteors;
    }

    public List<Meteor> getMeteors() {
        return meteors;
    }

    private void moveMeteors() {
        Iterator<Meteor> iterator = meteors.iterator();
        while (iterator.hasNext()) {
            Meteor meteor = iterator.next();
            Position newPosition = meteor.move();
            meteor.setPosition(newPosition);
            if (newPosition.getY() >= this.height) {
                iterator.remove();
            }
        }
        if (meteors.isEmpty()) {
            meteors.addAll(createMeteors());
        }
    }

    public void verifyCollisions() {
        Position spaceShipPosition = spaceShip.getPosition();

        for (Meteor meteor : meteors) {
            Position meteorPosition = meteor.getPosition();
            Position newMeteorPosition = meteor.position.moveUp();
            if (spaceShipPosition.equals(meteorPosition) || spaceShipPosition.equals(newMeteorPosition)) {
                running = false;
                System.out.println("You lost.");
                break;
            }
        }
    }

    private List<Power> createPowers() {
        Random random = new Random();
        ArrayList<Power> powers = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            powers.add(new Power(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return powers;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void retrievePowers(){
        for (Power power: powers) {
            if (spaceShip.getPosition().equals(power.getPosition())) {
                powers.remove(power);
                break;
            }
        }
    }
}

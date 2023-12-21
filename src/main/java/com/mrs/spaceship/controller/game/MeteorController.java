package com.mrs.spaceship.controller.game;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.elements.Meteor;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class MeteorController extends GameController {

    private long lastMovement;
    private Random random = new Random();


    public MeteorController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
        initializeMeteorSpawnTimings();
    }

    private void initializeMeteorSpawnTimings() {
        for (Meteor meteor : getModel().getMeteors()) {
            meteor.setLastSpawnTime(System.currentTimeMillis() - random.nextInt(10000));
        }
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (time - lastMovement > 250) {
            for (Meteor meteor : getModel().getMeteors())
                moveMeteor(meteor, meteor.getPosition().moveDown(), time);
            this.lastMovement = time;
        }
    }

    private boolean isValidMeteorPosition(int newX, List<Meteor> existingMeteors) {
        for (Meteor existingMeteor : existingMeteors) {
            if (existingMeteor.getPosition().getX() == newX) {
                return false;
            }
        }
        return true;
    }
    public void moveMeteor(Meteor meteor, Position position, long currentTime) {
        int min = 9;
        int max = getModel().getWidth() - 1;
        meteor.setPosition(position);
        if (position.getY() >= getModel().getHeight()) {
            int newX;
            long timeSinceLastSpawn = currentTime - meteor.getLastSpawnTime();
            long randomSpawnInterval = random.nextInt(10000) + 6000;
            if (timeSinceLastSpawn > randomSpawnInterval) {
                do {
                    newX = random.ints(min, max).findFirst().getAsInt();
                } while (!isValidMeteorPosition(newX, getModel().getMeteors()));

                meteor.setPosition(new Position(newX, -2));
                meteor.setLastSpawnTime(currentTime);
            }
        }
        else {
            meteor.setPosition(position);
        }
        if (getModel().getSpaceship().getPosition().equals(position))
            getModel().getSpaceship().reduceEnergy();
    }
}

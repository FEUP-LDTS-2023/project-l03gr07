package com.mrs.spaceship.model.game.arena;

import com.mrs.spaceship.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaBuilder {
    private final Random random;
    private int width;
    private int heigth;
    private Spaceship spaceship;
    public ArenaBuilder(int width, int height) {
        this.random = new Random();
        this.width = width;
        this.heigth = height;
    }

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setSpaceship(createSpaceship());
        arena.setEnemyShots(createEnemyShots());
        arena.setDefaultShots(createDefaultShots());
        arena.setDoubleShots(createDoubleShots());
        arena.setBurstShots(createBurstShots());
        arena.setTripleShots(createTripleShots());
        arena.setMeteors(createMeteors());
        arena.setPowers(createPowers());
        arena.setLimits(createLimits());
        arena.setSpecialEnemies(createSpecialEnemies());
        arena.setDefaultEnemies(createDefaultEnemies());
        return arena;
    }

    protected int getWidth() { return width; };
    protected int getHeight() { return heigth; };
    protected Spaceship createSpaceship() {
        this.spaceship = new Spaceship (width/2+4, heigth-3);
        return spaceship;
    }

    protected List<EnemyShot> createEnemyShots() {
        return new ArrayList<>();
    }
    protected List<DefaultShot> createDefaultShots() {
        return new ArrayList<>();
    }
    protected List<DoubleShot> createDoubleShots() { return new ArrayList<>(); }
    protected List<BurstShot> createBurstShots() { return new ArrayList<>(); }
    protected List<TripleShot> createTripleShots() { return new ArrayList<>(); }

    private boolean isValidMeteorPosition(List<Meteor> meteors, int x) {
        for (Meteor meteor : meteors) {
            if (meteor.getPosition().getX() == x) {
                return false;
            }
        }
        return true;
    }

    protected List<Meteor> createMeteors() {
        List<Meteor> meteors = new ArrayList<>();
        int min = 9;
        int max = width - 1;
        int x_aux;
        int y_aux;
        while (meteors.size() < 4) {
            x_aux = random.ints(min, max).findFirst().getAsInt();
            y_aux = random.ints(1, 10).findFirst().getAsInt();
            if (isValidMeteorPosition(meteors, x_aux)) {
                meteors.add(new Meteor(x_aux, -y_aux));
            }
        }
        return meteors;
    }

    protected List<Power> createPowers() { return new ArrayList<>(); }

    protected List<Limit> createLimits() {
        List<Limit> limits = new ArrayList<>();
        //draw horizontal limits
        for (int i = 8; i < width; i++) {
            limits.add(new Limit(i, -1));
            limits.add(new Limit(i, heigth-1));
        }
        //draw vertical limits
        for (int i = 0; i < heigth; i++) {
            limits.add(new Limit(8, i));
            limits.add(new Limit(width-1, i));
        }
        return limits;
    }

    protected List<SpecialEnemy> createSpecialEnemies() {
        List<SpecialEnemy> specialEnemies = new ArrayList<>();
        int x_min = 9;
        int x_max = width - 1;
        int y_min = 0;
        int y_max = 2;
        int x_aux, y_aux;
        while (specialEnemies.size() < 2) {
            x_aux = random.ints(x_min, x_max).findFirst().getAsInt();
            y_aux = random.ints(y_min, y_max).findFirst().getAsInt();
            specialEnemies.add(new SpecialEnemy(x_aux, y_aux, 5));
        }
        return specialEnemies;
    }

    protected List<DefaultEnemy> createDefaultEnemies() {
        List<DefaultEnemy> defaultEnemies = new ArrayList<>();
        int x_min = 9;
        int x_max = width - 1;
        int y_min = 3;
        int y_max = heigth/2 - 4;
        int x_aux, y_aux;
        while (defaultEnemies.size() < 2) {
            x_aux = random.ints(x_min, x_max).findFirst().getAsInt();
            y_aux = random.ints(y_min, y_max).findFirst().getAsInt();
            defaultEnemies.add(new DefaultEnemy(x_aux, y_aux, 3));
        }
        return defaultEnemies;
    }
}

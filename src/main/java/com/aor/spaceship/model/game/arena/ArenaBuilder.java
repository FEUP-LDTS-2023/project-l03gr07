package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.game.elements.DefaultShots;
import com.aor.spaceship.model.game.elements.Limit;
import com.aor.spaceship.model.game.elements.Meteor;
import com.aor.spaceship.model.game.elements.Spaceship;

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
        arena.setDefaultShots(createDefaultShots());
        arena.setMeteors(createMeteors());
        arena.setLimits(createLimits());
        return arena;
    }

    protected int getWidth() { return width; };
    protected int getHeight() { return heigth; };
    protected Spaceship createSpaceship() {
        this.spaceship = new Spaceship (width/2, heigth/2);
        return spaceship;
    }
    protected List<DefaultShots> createDefaultShots() {
        return new ArrayList<>();
    }

    protected List<Meteor> createMeteors() {
        List<Meteor> meteors = new ArrayList<>();
        int min = 8;
        int max = width-2;
        for (int i = 0; i <= 2; i++) {
            meteors.add(new Meteor(random.ints(min, max).findFirst().getAsInt(), -2));
        }
        return meteors;
    }

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
}

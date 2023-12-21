package com.mrs.spaceship.model.game.elements;

public class Meteor extends Element {
    private long lastSpawnTime;

    public Meteor(int x, int y) {
        super(x, y);
        this.lastSpawnTime = 0;
    }
    public long getLastSpawnTime() {
        return lastSpawnTime;
    }

    public void setLastSpawnTime(long lastSpawnTime) {
        this.lastSpawnTime = lastSpawnTime;
    }
}

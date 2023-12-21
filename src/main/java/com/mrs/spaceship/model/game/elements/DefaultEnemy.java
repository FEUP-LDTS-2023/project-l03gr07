package com.mrs.spaceship.model.game.elements;

public class DefaultEnemy extends Element {
    private int health;

    public DefaultEnemy(int x, int y, int health) {
        super(x, y);
        this.health = health;
    }

    public int getHealth() { return health; }

    public void reduceHealth(int damage) { this.health -= damage; }
}

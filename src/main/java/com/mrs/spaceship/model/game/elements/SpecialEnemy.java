package com.mrs.spaceship.model.game.elements;

public class SpecialEnemy extends Element {
    private int health;
    public SpecialEnemy(int x, int y, int health) {
        super(x, y);
        this.health = health;
    }

    public int getHealth() { return health; }

    public void reduceHealth(int damage) { this.health -= damage; }
}

package com.mrs.spaceship.model.game.elements;

public class DefaultShot extends Bullet {

    private int damage;
    public DefaultShot(int x, int y) {
        super(x, y);
        this.damage = 1;
    }

    public int getDamage() { return this.damage; }
}

package com.mrs.spaceship.model.game.elements;

public class DoubleShot extends Bullet {

    private int damage;
    public DoubleShot(int x, int y) {
        super(x, y);
        this.damage = 2;
    }

    public int getDamage() { return this.damage; }
}

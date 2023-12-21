package com.mrs.spaceship.model.game.elements;

public class BurstShot extends Bullet{
    private int damage;
    public BurstShot(int x, int y) {
        super(x, y);
        this.damage = 1;
    }

    public int getDamage() { return this.damage; }
}

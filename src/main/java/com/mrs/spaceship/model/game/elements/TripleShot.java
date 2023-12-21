package com.mrs.spaceship.model.game.elements;

public class TripleShot extends Bullet {
    private int damage;
    public TripleShot(int x, int y) {
        super(x, y);
        damage = 1;
    }

    public int getDamage() { return this.damage; }
}

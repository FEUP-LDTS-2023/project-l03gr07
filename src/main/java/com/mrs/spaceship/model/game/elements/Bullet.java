package com.mrs.spaceship.model.game.elements;

public class Bullet extends Element {
    public Bullet(int x, int y) {
        super(x, y);
    }

    public void moveBulletUp() {
        this.setPosition(getPosition().moveUp());
    }

    public void moveBulletDown() {
        this.setPosition(getPosition().moveDown());
    }
}

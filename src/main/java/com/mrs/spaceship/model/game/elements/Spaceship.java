package com.mrs.spaceship.model.game.elements;

public class Spaceship extends Element {
    private int energy;
    private int score;
    private String shot;
    public Spaceship(int x, int y) {
        super(x, y);
        this.energy = 3;
        this.shot = "defaultShot";
    }

    public int getEnergy() {
        return energy;
    }

    public void increaseEnergy() { this.energy++; }

    public void reduceEnergy() {
        this.energy--;
    }

    public int getScore() { return score; }

    public void addScore(int score) { this.score += score; }

    public String getShot() { return this.shot; }
    public void setShot(String shot) { this.shot = shot; }

}

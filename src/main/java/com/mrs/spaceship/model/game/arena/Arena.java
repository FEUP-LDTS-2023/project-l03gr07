package com.mrs.spaceship.model.game.arena;

import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.elements.*;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Arena {
    private int width;
    private int height;
    private Spaceship spaceship;
    private List<EnemyShot> enemyShots;
    private List<DefaultShot> defaultShots;
    private List<DoubleShot> doubleShots;
    private List<BurstShot> burstShots;
    private List<TripleShot> tripleShots;
    private List<Meteor> meteors;
    private List<Power> powers;
    private List<Limit> limits;
    private List<DefaultEnemy> defaultEnemies;
    private List<SpecialEnemy> specialEnemies;
    private ExecutorService DefaultEnemyexecutorService = Executors.newSingleThreadExecutor();
    private ExecutorService SpecialEnemyexecutorService = Executors.newSingleThreadExecutor();
    private final Random random;
    private Timer powerTimer;


    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        this.random = new Random();
        this.powerTimer = new Timer();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public Spaceship getSpaceship() { return spaceship; }

    public List<EnemyShot> getEnemyShots() { return enemyShots; }
    public List<DefaultShot> getDefaultShots() { return defaultShots; }
    public List<DoubleShot> getDoubleShots() { return doubleShots; }
    public List<BurstShot> getBurstShots() { return burstShots; }
    public List<TripleShot> getTripleShots() { return tripleShots; }
    public List<Meteor> getMeteors() {return meteors; }

    public List<Power> getPowers() {return powers; }
    public List<Limit> getLimits() { return limits; }

    public List<DefaultEnemy> getDefaultEnemies() { return defaultEnemies; }
    public List<SpecialEnemy> getSpecialEnemies() { return specialEnemies; }

    public ExecutorService getDefaultEnemyexecutorService() {return DefaultEnemyexecutorService; }

    public ExecutorService getSpecialEnemyexecutorService() {return SpecialEnemyexecutorService; }

    public Timer getPowerTimer() { return powerTimer; }

    public void setSpaceship(Spaceship spaceship) { this.spaceship = spaceship; }

    public void setEnemyShots(List<EnemyShot> enemyShots) { this.enemyShots = enemyShots; }
    public void setDefaultShots(List<DefaultShot> defaultShots) { this.defaultShots = defaultShots; }
    public void setDoubleShots(List<DoubleShot> doubleShots) { this.doubleShots = doubleShots; }
    public void setBurstShots(List<BurstShot> burstShots) { this.burstShots = burstShots; }
    public void setTripleShots(List<TripleShot> tripleShots) { this.tripleShots = tripleShots; }
    public void setMeteors(List<Meteor> meteors) { this.meteors = meteors; }

    public void setPowers(List<Power> powers) { this.powers = powers; }
    public void setLimits(List<Limit> limits) { this.limits = limits; }

    public void setDefaultEnemies(List<DefaultEnemy> defaultEnemies) { this.defaultEnemies = defaultEnemies; }

    public void setSpecialEnemies(List<SpecialEnemy> specialEnemies) { this.specialEnemies = specialEnemies; }

    public boolean hasCollided(Position position) {
        for (Meteor meteor : meteors) {
            if (meteor.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLimit(Position position) {
        for (Limit limit : limits) {
            if (limit.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEnemy(Position position) {
        for (SpecialEnemy specialEnemy : specialEnemies) {
            if (specialEnemy.getPosition().equals(position)) {
                return true;
            }
        }
        for (DefaultEnemy defaultEnemy : defaultEnemies) {
            if (defaultEnemy.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPower(Position position) {
        for (Power power : powers) {
            if (power.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBeyondMovementLimit(Position position) {
        if (position.getX() < 9 || position.getX() > width -1) {
            return true;
        }
        else if (position.getY() < 3 || position.getY() > height/2 - 2) {
            return true;
        }
        return false;
    }

    public void GetRandomPower() {
        int randomPower = random.ints(1, 5).findFirst().getAsInt();
        switch (randomPower) {
            case 1:
                this.spaceship.increaseEnergy();
                break;
            case 2:
                this.spaceship.setShot("doubleShot");
                schedulePowerDuration(10);
                System.out.println("DS");
                break;
            case 3:
                this.spaceship.setShot("burst");
                schedulePowerDuration(5);
                System.out.println("BS");
                break;
            case 4:
                this.spaceship.setShot("tripleShot");
                schedulePowerDuration(5);
                System.out.println("TS");
                break;
        }
    }

    private void schedulePowerDuration(int seconds) {
        powerTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                spaceship.setShot("defaultShot");
            }
        }, seconds * 1000);
    }
    public void removePower(Position position) {
        for (int i = 0; i < powers.size(); i++) {
            if (powers.get(i).getPosition().equals(position)) {
                powers.remove(i);
                spaceship.addScore(50);
                GetRandomPower();
            }
        }
    }

    public void reduceHPSpecialEnemy(Position position, int damage) {
        for (int i = 0; i < specialEnemies.size(); i++) {
            if (specialEnemies.get(i).getPosition().equals(position)) {
                specialEnemies.get(i).reduceHealth(damage);
                if (specialEnemies.get(i).getHealth() <= 0) {
                    specialEnemies.remove(i);
                    powers.add(new Power(position.getX(), position.getY()));
                    spaceship.addScore(250);
                }
            }
        }
        if (getSpecialEnemies().isEmpty()) {
            scheduleSpecialEnemySpawnWithDelay();
        }
    }

    private void scheduleSpecialEnemySpawnWithDelay() {
        SpecialEnemyexecutorService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (getSpecialEnemies().isEmpty()) {
                getSpecialEnemies().add(new SpecialEnemy(random.ints(9, width - 1).findFirst().getAsInt(), random.ints(0, 2).findFirst().getAsInt(), 5));
            }
        });
    }

    public void reduceHPDefaultEnemy(Position position, int damage) {
        for (int i = 0; i < defaultEnemies.size(); i++) {
            if (defaultEnemies.get(i).getPosition().equals(position)) {
                defaultEnemies.get(i).reduceHealth(damage);
                if (defaultEnemies.get(i).getHealth() <= 0) {
                    defaultEnemies.remove(i);
                    spaceship.addScore(150);
                }
            }
        }
        if (getDefaultEnemies().isEmpty()) {
            scheduleDefaultEnemySpawnWithDelay();
        }
    }

    private void scheduleDefaultEnemySpawnWithDelay() {
        DefaultEnemyexecutorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (getDefaultEnemies().isEmpty()) {
                getDefaultEnemies().add(new DefaultEnemy(random.ints(9, width - 1).findFirst().getAsInt(), random.ints(3, height/2 - 4).findFirst().getAsInt(), 3));
            }
        });
    }
}

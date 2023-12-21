package com.mrs.spaceship.controller.game;

import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.elements.*;

import java.util.Iterator;

public class ShootingController {
    private Arena arena;
    private Spaceship spaceship;
    public ShootingController (Arena arena, Spaceship spaceship) {
        this.arena = arena;
        this.spaceship = spaceship;
    }
     public void defaultShot() {
        arena.getDefaultShots().add(new DefaultShot(spaceship.getPosition().getX(), spaceship.getPosition().moveUp().getY()));
     }

     public void doubleShots() {
        arena.getDoubleShots().add(new DoubleShot(spaceship.getPosition().getX(), spaceship.getPosition().moveUp().getY()));
     }
     public void burstShots() {
        arena.getBurstShots().add(new BurstShot(spaceship.getPosition().getX(), spaceship.getPosition().moveUp().getY()));
     }
     public void tripleShots() {
        arena.getTripleShots().add(new TripleShot(spaceship.getPosition().getX(), spaceship.getPosition().moveUp().getY()));
        arena.getTripleShots().add(new TripleShot(spaceship.getPosition().moveLeft().getX(), spaceship.getPosition().moveUp().getY()));
        arena.getTripleShots().add(new TripleShot(spaceship.getPosition().moveRight().getX(), spaceship.getPosition().moveUp().getY()));
     }
     public void moveDefaultShot() {
        for (DefaultShot defaultShot : arena.getDefaultShots()) {
            defaultShot.moveBulletUp();
            if (arena.hasCollided(defaultShot.getPosition()) || arena.hasCollided(defaultShot.getPosition().moveUp())) {
                defaultShot.setPosition(new Position(0, -2));
            }
            if (arena.isEnemy(defaultShot.getPosition())) {
                arena.reduceHPSpecialEnemy(defaultShot.getPosition(), defaultShot.getDamage());
                arena.reduceHPDefaultEnemy(defaultShot.getPosition(), defaultShot.getDamage());
                defaultShot.setPosition(new Position(0, -2));
            }
        }
        cleanUpDefaultShots();
     }

    public void moveDoubletShot() {
        for (DoubleShot doubleShot : arena.getDoubleShots()) {
            doubleShot.moveBulletUp();
            if (arena.hasCollided(doubleShot.getPosition()) || arena.hasCollided(doubleShot.getPosition().moveUp())) {
                doubleShot.setPosition(new Position(0, -2));
            }
            if (arena.isEnemy(doubleShot.getPosition())) {
                arena.reduceHPSpecialEnemy(doubleShot.getPosition(), doubleShot.getDamage());
                arena.reduceHPDefaultEnemy(doubleShot.getPosition(), doubleShot.getDamage());
                doubleShot.setPosition(new Position(0, -2));
            }
        }
        cleanUpDoubleShots();
    }

    public void moveBurstShots() {
        for (BurstShot burstShot : arena.getBurstShots()) {
            burstShot.moveBulletUp();
            if (arena.hasCollided(burstShot.getPosition()) || arena.hasCollided(burstShot.getPosition().moveUp())) {
                burstShot.setPosition(new Position(0, -2));
            }
            if (arena.isEnemy(burstShot.getPosition())) {
                arena.reduceHPSpecialEnemy(burstShot.getPosition(), burstShot.getDamage());
                arena.reduceHPDefaultEnemy(burstShot.getPosition(), burstShot.getDamage());
                burstShot.setPosition(new Position(0, -2));
            }
        }
        cleanUpBurstShots();
    }

    public void moveTripleShots() {
        for (TripleShot tripleShot : arena.getTripleShots()) {
            tripleShot.moveBulletUp();
            if (arena.hasCollided(tripleShot.getPosition()) || arena.hasCollided(tripleShot.getPosition().moveUp())) {
                tripleShot.setPosition(new Position(0, -2));
            }
            if (arena.isEnemy(tripleShot.getPosition())) {
                arena.reduceHPSpecialEnemy(tripleShot.getPosition(), tripleShot.getDamage());
                arena.reduceHPDefaultEnemy(tripleShot.getPosition(), tripleShot.getDamage());
                tripleShot.setPosition(new Position(0, -2));
            }
        }
        cleanUpTripleShots();
    }

    private void cleanUpDefaultShots() {
        Iterator<DefaultShot> iterator = arena.getDefaultShots().iterator();
        while (iterator.hasNext()) {
            DefaultShot defaultShot = iterator.next();
            if (defaultShot.getPosition().getY() < 0) {
                iterator.remove();
            }
        }
    }

    private void cleanUpDoubleShots() {
        Iterator<DoubleShot> iterator = arena.getDoubleShots().iterator();
        while (iterator.hasNext()) {
            DoubleShot doubleShot = iterator.next();
            if (doubleShot.getPosition().getY() < 0) {
                iterator.remove();
            }
        }
    }

    private void cleanUpBurstShots() {
        Iterator<BurstShot> iterator = arena.getBurstShots().iterator();
        while (iterator.hasNext()) {
            BurstShot burstShot = iterator.next();
            if (burstShot.getPosition().getY() < 0) {
                iterator.remove();
            }
        }
    }

    private void cleanUpTripleShots() {
        Iterator<TripleShot> iterator = arena.getTripleShots().iterator();
        while (iterator.hasNext()) {
            TripleShot tripleShot = iterator.next();
            if (tripleShot.getPosition().getY() < 0) {
                iterator.remove();
            }
        }
    }
}

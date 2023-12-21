package com.mrs.spaceship.controller.game;

import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.elements.DefaultEnemy;
import com.mrs.spaceship.model.game.elements.EnemyShot;

import java.util.Iterator;
import java.util.List;

public class EnemyShootingController {
    private Arena arena;
    private List<DefaultEnemy> defaultEnemies;

    public EnemyShootingController(Arena arena, List<DefaultEnemy> defaultEnemies) {
        this.arena = arena;
        this.defaultEnemies = defaultEnemies;
    }

    public void DefaultEnemyShot() {
        for (DefaultEnemy defaultEnemy : defaultEnemies) {
            arena.getEnemyShots().add(new EnemyShot(defaultEnemy.getPosition().getX(), defaultEnemy.getPosition().moveDown().getY()));
        }
    }

    public void moveEnemyShot() {
        for (EnemyShot enemyShot : arena.getEnemyShots()) {
            enemyShot.moveBulletDown();
            if (arena.hasCollided(enemyShot.getPosition()) || arena.hasCollided(enemyShot.getPosition().moveDown()) || arena.isEnemy(enemyShot.getPosition())) {
                enemyShot.setPosition(new Position(0, arena.getHeight()));
            }
            if (arena.getSpaceship().getPosition().equals(enemyShot.getPosition()))
                arena.getSpaceship().reduceEnergy();
        }
        cleanUpEnemyShots();
    }

    private void cleanUpEnemyShots() {
        Iterator<EnemyShot> iterator = arena.getEnemyShots().iterator();
        while (iterator.hasNext()) {
            EnemyShot enemyShot = iterator.next();
            if (enemyShot.getPosition().getY() > arena.getHeight()) {
                iterator.remove();
            }
        }
    }
}

package com.mrs.spaceship.controller.game;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.elements.SpecialEnemy;

import java.io.IOException;
import java.util.Random;

public class SpecialEnemyController extends GameController {
    private long lastMovement;
    public SpecialEnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        Random random = new Random();
        if (time - lastMovement > 300) {
            for (SpecialEnemy specialEnemy : getModel().getSpecialEnemies()) {
                int randomPosition = random.ints(1, 3).findFirst().getAsInt();
                switch (randomPosition) {
                    case 1:
                        if (!getModel().isLimit(specialEnemy.getPosition().moveLeft()) && !getModel().hasCollided(specialEnemy.getPosition().moveLeft()) && !getModel().isEnemy(specialEnemy.getPosition().moveLeft()))
                            moveSpecialEnemy(specialEnemy, specialEnemy.getPosition().moveLeft());
                        break;
                    case 2:
                        if (!getModel().isLimit(specialEnemy.getPosition().moveRight()) && !getModel().hasCollided(specialEnemy.getPosition().moveRight()) && !getModel().isEnemy(specialEnemy.getPosition().moveRight()))
                            moveSpecialEnemy(specialEnemy, specialEnemy.getPosition().moveRight());
                        break;
                    default:
                }
            }
            this.lastMovement = time;
        }
    }

    public void moveSpecialEnemy(SpecialEnemy specialEnemy, Position position) {
        specialEnemy.setPosition(position);
    }
}

package com.mrs.spaceship.controller.game;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;

import java.io.IOException;

public class SpaceshipController extends GameController {
    private long lastMovement;
    private long lastDefaultShot;
    private long lastDoubleShot;
    private long lastBurstShot;
    private long lastTripleShot;

    ShootingController shootingController;
    public SpaceshipController(Arena arena) {
        super(arena);
        lastMovement = 0;
        lastDefaultShot = 0;
        lastDoubleShot = 0;
        lastBurstShot = 0;
        lastTripleShot = 0;
        shootingController = new ShootingController(arena, getModel().getSpaceship());
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        switch (getModel().getSpaceship().getShot()) {
            case "defaultShot":
                if (time - lastMovement > 300) {
                    shootingController.defaultShot();
                    this.lastMovement = time;
                }
                break;
            case "doubleShot":
                if (time - lastMovement > 300) {
                    shootingController.doubleShots();
                    this.lastMovement = time;
                }
                break;
            case "burst":
                if (time - lastMovement > 10) {
                    shootingController.burstShots();
                    this.lastMovement = time;
                }
            case "tripleShot":
                if (time - lastMovement > 300) {
                    shootingController.tripleShots();
                    this.lastMovement = time;
                }
        }
        if (time - lastDefaultShot > 100) {
            shootingController.moveDefaultShot();
            this.lastDefaultShot = time;
        }
        if (time - lastDoubleShot > 100) {
            shootingController.moveDoubletShot();
            this.lastDoubleShot = time;
        }
        if (time - lastBurstShot > 10) {
            shootingController.moveBurstShots();
            this.lastBurstShot = time;
        }
        if (time - lastTripleShot > 100) {
            shootingController.moveTripleShots();
            this.lastTripleShot = time;
        }

        if (getModel().isPower(getModel().getSpaceship().getPosition())) {
            getModel().removePower(getModel().getSpaceship().getPosition());
        }
        if (action == GUI.Action.LEFT) { moveSpaceshipLeft(); }
        if (action == GUI.Action.RIGHT) { moveSpaceshipRight(); }
        if (action == GUI.Action.UP) { moveSpaceshipUp(); }
        if (action == GUI.Action.DOWN) { moveSpaceshipDown(); }
    }

    public void moveSpaceship(Position position) {
        if (!getModel().isLimit(position)) {
            getModel().getSpaceship().setPosition(position);
            if (getModel().isPower(position) || getModel().isPower(position.moveDown()) || getModel().isPower(position.moveUp())) {
                getModel().removePower(position);
            }
        }
        if (getModel().hasCollided(position) || getModel().isEnemy(position)) {
            getModel().getSpaceship().reduceEnergy();
        }
    }

    public void moveSpaceshipLeft() {
        moveSpaceship(getModel().getSpaceship().getPosition().moveLeft());
    }
    public void moveSpaceshipRight() {
        moveSpaceship(getModel().getSpaceship().getPosition().moveRight());
    }
    public void moveSpaceshipUp() {
        moveSpaceship(getModel().getSpaceship().getPosition().moveUp());
    }
    public void moveSpaceshipDown() {
        moveSpaceship(getModel().getSpaceship().getPosition().moveDown());
    }

}

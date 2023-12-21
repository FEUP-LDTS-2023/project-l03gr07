package com.mrs.spaceship.controller;

import com.mrs.spaceship.controller.game.SpaceshipController;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceshipControllerTest {
    private SpaceshipController spaceshipController;
    private Spaceship spaceship;
    private Arena arena;
    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        arena.setLimits(createLimits());
        arena.setMeteors(createMeteors());
        arena.setPowers(createPowers());
        arena.setSpecialEnemies(createSpecialEnemy());
        arena.setDefaultEnemies(createDefaultEnemy());
        spaceship = new Spaceship(10, 10);
        arena.setSpaceship(spaceship);
        spaceshipController = new SpaceshipController(arena);
    }

    protected List<Limit> createLimits() {
        return new ArrayList<>();
    }

    protected List<Meteor> createMeteors() {
        return new ArrayList<>();
    }

    protected List<Power> createPowers() { return new ArrayList<>(); }

    protected List<DefaultEnemy> createDefaultEnemy() { return new ArrayList<>(); }

    protected List<SpecialEnemy> createSpecialEnemy() { return new ArrayList<>(); }
    @Test
    void moveSpaceshipDown() {
        spaceshipController.moveSpaceshipDown();
        assertEquals(new Position(10, 11), spaceship.getPosition());
    }
    @Test
    void moveSpaceshipLeft() {
        spaceshipController.moveSpaceshipLeft();
        assertEquals(new Position(9, 10), spaceship.getPosition());
    }
    @Test
    void moveSpaceshipRight() {
        spaceshipController.moveSpaceshipRight();
        assertEquals(new Position(11, 10), spaceship.getPosition());
    }
    @Test
    void moveSpaceshipUp() {
        spaceshipController.moveSpaceshipUp();
        assertEquals(new Position(10, 9), spaceship.getPosition());
    }
}

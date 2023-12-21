package com.mrs.spaceship.controller;

import com.mrs.spaceship.controller.game.DefaultEnemyController;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.elements.DefaultEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultEnemyControllerTest {
    private DefaultEnemy defaultEnemie;
    private DefaultEnemyController defaultEnemyController;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        defaultEnemie = new DefaultEnemy(10, 10, 2);
        defaultEnemyController = new DefaultEnemyController(arena);
    }

    @Test
    void moveDefaultEnemy() {
        defaultEnemyController.moveDefaultEnemy(defaultEnemie, new Position(10, 11));
        assertEquals(new Position(10, 11), defaultEnemie.getPosition());
    }
}

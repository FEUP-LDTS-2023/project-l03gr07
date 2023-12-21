package com.mrs.spaceship.controller;

import com.mrs.spaceship.controller.game.SpecialEnemyController;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.elements.SpecialEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialEnemyControllerTest {
    private SpecialEnemy specialEnemy;
    private SpecialEnemyController specialEnemyController;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        specialEnemy = new SpecialEnemy(10, 10, 5);
        specialEnemyController = new SpecialEnemyController(arena);
    }

    @Test
    void moveSpecialEnemy() {
        specialEnemyController.moveSpecialEnemy(specialEnemy, new Position(10, 11));
        assertEquals(new Position(10, 11), specialEnemy.getPosition());
    }
}

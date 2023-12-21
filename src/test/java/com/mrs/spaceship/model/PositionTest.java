package com.mrs.spaceship.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private Position position;
    @BeforeEach
    void setUp() {
        position = new Position(10, 10);
    }

    @Test
    void getRight() {
        assertEquals(new Position(11, 10), position.moveRight());
    }
    @Test
    void getLeft() {
        assertEquals(new Position(9, 10), position.moveLeft());
    }
    @Test
    void getDown() {
        assertEquals(new Position(10, 11), position.moveDown());
    }
    @Test
    void getUp() {
        assertEquals(new Position(10, 9), position.moveUp());
    }
}

package com.mrs.spaceship.controller;

import com.mrs.spaceship.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControllerTest {
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void createMenu() {
        assertEquals("Start", menu.getEntry(0));
        assertEquals("Instructions", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
    }
    @Test
    void moveMenu() {
        assertEquals(3, menu.getNumberEntries());
        assertEquals(0, menu.getCurrentEntry());
        menu.nextEntry();
        assertEquals(1, menu.getCurrentEntry());
        assertEquals(true, menu.isSelectedInstructions());
        menu.previousEntry();
        assertEquals(0, menu.getCurrentEntry());
        assertEquals(true, menu.isSelectedStart());
        menu.previousEntry();
        assertEquals(2, menu.getCurrentEntry());
        assertEquals(true, menu.isSelectedExit());
    }
}

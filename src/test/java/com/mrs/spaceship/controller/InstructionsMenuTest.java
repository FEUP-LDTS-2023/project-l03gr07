package com.mrs.spaceship.controller;

import com.mrs.spaceship.model.menu.InstructionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsMenuTest {
    private InstructionsMenu instructionsMenu;

    @BeforeEach
    void setUp() {
        instructionsMenu = new InstructionsMenu();
    }

    @Test
    void createMenu() {
        assertEquals("⬤", instructionsMenu.getEntry(0));
        assertEquals("⬤", instructionsMenu.getEntry(1));
    }
    @Test
    void moveMenu() {
        assertEquals(2, instructionsMenu.getNumberEntries());
        assertEquals(0, instructionsMenu.getCurrentEntry());
        instructionsMenu.nextEntry();
        assertEquals(1, instructionsMenu.getCurrentEntry());
        assertEquals(true, instructionsMenu.isSelectedExit());
        instructionsMenu.previousEntry();
        assertEquals(0, instructionsMenu.getCurrentEntry());
        assertEquals(true, instructionsMenu.isSelectedStay());
        instructionsMenu.previousEntry();
        assertEquals(1, instructionsMenu.getCurrentEntry());
        assertEquals(true, instructionsMenu.isSelectedExit());
    }
}

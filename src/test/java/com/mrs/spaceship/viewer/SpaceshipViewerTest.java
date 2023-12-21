package com.mrs.spaceship.viewer;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.Spaceship;
import com.mrs.spaceship.viewer.game.SpaceshipViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpaceshipViewerTest {
    private Spaceship spaceship;
    private SpaceshipViewer spaceshipViewer;
    private GUI gui;
    @BeforeEach
    void setUp() {
        spaceship =  new Spaceship(5, 5);
        spaceshipViewer = new SpaceshipViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        spaceshipViewer.draw(spaceship, gui);
        Mockito.verify(gui, Mockito.times(1)).drawSpaceship(spaceship.getPosition());
    }
}

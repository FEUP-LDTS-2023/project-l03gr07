package com.mrs.spaceship.viewer;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.DefaultShot;
import com.mrs.spaceship.viewer.game.DefaultShotsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DefaultShotViewerTest {
    private DefaultShot defaultShot;
    private DefaultShotsViewer defaultShotsViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        defaultShot = new DefaultShot(10,10);
        defaultShotsViewer = new DefaultShotsViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        defaultShotsViewer.draw(defaultShot, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDefaultShots(defaultShot.getPosition());
    }
}

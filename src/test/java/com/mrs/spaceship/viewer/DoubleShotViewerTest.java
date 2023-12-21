package com.mrs.spaceship.viewer;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.DoubleShot;
import com.mrs.spaceship.viewer.game.DoubleShotsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DoubleShotViewerTest {
    private DoubleShot doubleShot;
    private DoubleShotsViewer doubleShotsViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        doubleShot = new DoubleShot(10,10);
        doubleShotsViewer = new DoubleShotsViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        doubleShotsViewer.draw(doubleShot, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDoubleShots(doubleShot.getPosition());
    }
}

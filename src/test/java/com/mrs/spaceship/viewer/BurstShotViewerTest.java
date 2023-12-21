package com.mrs.spaceship.viewer;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.BurstShot;
import com.mrs.spaceship.viewer.game.BurstShotsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BurstShotViewerTest {
    private BurstShot burstShot;
    private BurstShotsViewer burstShotsViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        burstShot = new BurstShot(10,10);
        burstShotsViewer = new BurstShotsViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        burstShotsViewer.draw(burstShot, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBurstShots(burstShot.getPosition());
    }
}

package com.mrs.spaceship.viewer;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.Power;
import com.mrs.spaceship.viewer.game.PowerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerViewerTest {
    private Power power;
    private PowerViewer powerViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        power = new Power(10,10);
        powerViewer = new PowerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        powerViewer.draw(power, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPower(power.getPosition());
    }
}

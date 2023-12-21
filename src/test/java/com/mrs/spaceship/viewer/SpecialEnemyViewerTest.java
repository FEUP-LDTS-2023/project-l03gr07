package com.mrs.spaceship.viewer;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.SpecialEnemy;
import com.mrs.spaceship.viewer.game.SpecialEnemiesViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpecialEnemyViewerTest {
    private SpecialEnemy specialEnemy;
    private SpecialEnemiesViewer specialEnemiesViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        specialEnemy = new SpecialEnemy(10,10, 5);
        specialEnemiesViewer = new SpecialEnemiesViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        specialEnemiesViewer.draw(specialEnemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawSpecialEnemies(specialEnemy.getPosition());
    }
}

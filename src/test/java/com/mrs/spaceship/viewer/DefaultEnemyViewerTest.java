package com.mrs.spaceship.viewer;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.DefaultEnemy;
import com.mrs.spaceship.viewer.game.DefaultEnemiesViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DefaultEnemyViewerTest {
    private DefaultEnemy defaultEnemy;
    private DefaultEnemiesViewer defaultEnemiesViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        defaultEnemy = new DefaultEnemy(20, 10, 1);
        defaultEnemiesViewer = new DefaultEnemiesViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        defaultEnemiesViewer.draw(defaultEnemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDefaultEnemies(defaultEnemy.getPosition());
    }
}

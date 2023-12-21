package com.mrs.spaceship.viewer;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.EnemyShot;
import com.mrs.spaceship.viewer.game.ElementViewer;
import com.mrs.spaceship.viewer.game.EnemyShotsViewer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class EnemyShotViewerTest {

    @Test
    public void testDraw() {

        GUI mockGUI = mock(GUI.class);


        EnemyShot enemyShot = new EnemyShot(5,5);



        ElementViewer<EnemyShot> enemyShotsViewer = new EnemyShotsViewer();

        enemyShotsViewer.draw(enemyShot, mockGUI);

        verify(mockGUI, times(1)).drawEnemyShots(enemyShot.getPosition());
    }
}

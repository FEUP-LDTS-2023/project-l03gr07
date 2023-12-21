package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.EnemyShot;

public class EnemyShotsViewer implements ElementViewer<EnemyShot> {
    @Override
    public void draw(EnemyShot enemyShots, GUI gui) { gui.drawEnemyShots(enemyShots.getPosition()); }
}

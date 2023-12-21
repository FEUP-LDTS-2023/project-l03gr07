package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.DefaultEnemy;

public class DefaultEnemiesViewer implements ElementViewer<DefaultEnemy> {
    @Override
    public void draw(DefaultEnemy defaultEnemy, GUI gui) { gui.drawDefaultEnemies(defaultEnemy.getPosition()); }
}

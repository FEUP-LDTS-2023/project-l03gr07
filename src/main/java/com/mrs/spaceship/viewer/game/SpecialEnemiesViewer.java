package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.SpecialEnemy;

public class SpecialEnemiesViewer implements ElementViewer<SpecialEnemy> {

    @Override
    public void draw(SpecialEnemy specialEnemy, GUI gui) { gui.drawSpecialEnemies(specialEnemy.getPosition()); }
}

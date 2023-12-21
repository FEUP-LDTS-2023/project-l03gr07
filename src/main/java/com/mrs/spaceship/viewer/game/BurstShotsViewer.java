package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.BurstShot;

public class BurstShotsViewer implements ElementViewer<BurstShot> {
    @Override
    public void draw(BurstShot burstShot, GUI gui) { gui.drawBurstShots(burstShot.getPosition()); }
}

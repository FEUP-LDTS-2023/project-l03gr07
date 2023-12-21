package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.DefaultShot;

public class DefaultShotsViewer implements ElementViewer<DefaultShot> {
    @Override
    public void draw(DefaultShot defaultShots, GUI gui) { gui.drawDefaultShots(defaultShots.getPosition());}
}

package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.DoubleShot;

public class DoubleShotsViewer implements ElementViewer<DoubleShot> {
    @Override
    public void draw(DoubleShot doubleShot, GUI gui) { gui.drawDoubleShots(doubleShot.getPosition());}

}

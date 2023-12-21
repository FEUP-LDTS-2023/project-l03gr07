package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.TripleShot;

public class TripleShotsViewer implements ElementViewer<TripleShot> {
    @Override
    public void draw(TripleShot tripleShot, GUI gui) { gui.drawTripleShots(tripleShot.getPosition()); }
}

package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.Spaceship;

public class SpaceshipViewer implements ElementViewer<Spaceship> {
    @Override
    public void draw(Spaceship spaceship, GUI gui) { gui.drawSpaceship(spaceship.getPosition());}
}

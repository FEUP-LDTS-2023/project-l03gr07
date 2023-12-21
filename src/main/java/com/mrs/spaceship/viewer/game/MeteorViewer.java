package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.Meteor;

public class MeteorViewer implements ElementViewer<Meteor> {

    @Override
    public void draw(Meteor meteor, GUI gui) { gui.drawMeteor(meteor.getPosition()); }
}

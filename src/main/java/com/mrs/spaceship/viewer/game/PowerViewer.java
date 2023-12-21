package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.Power;

public class PowerViewer implements ElementViewer<Power> {

    @Override
    public void draw(Power power, GUI gui) { gui.drawPower(power.getPosition()); }
}

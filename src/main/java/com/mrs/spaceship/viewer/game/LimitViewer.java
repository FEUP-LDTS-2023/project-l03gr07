package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.Limit;

public class LimitViewer implements ElementViewer<Limit> {
    @Override
    public void draw(Limit limit, GUI gui) { gui.drawLimits(limit.getPosition()); }
}

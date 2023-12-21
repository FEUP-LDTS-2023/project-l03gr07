package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

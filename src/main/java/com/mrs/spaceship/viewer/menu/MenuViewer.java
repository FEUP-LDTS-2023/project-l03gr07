package com.mrs.spaceship.viewer.menu;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.menu.Menu;
import com.mrs.spaceship.viewer.Viewer;
import com.mrs.spaceship.model.Position;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(Application application, GUI gui) {
        gui.drawText(new Position(3, 3),  " ----------------------", "#FFFFFF");
        gui.drawText(new Position(3, 4),  "|         SPACE        |", "#FFFFFF");
        gui.drawText(new Position(3, 5),  "|        SHOOTER       |", "#FFFFFF");
        gui.drawText(new Position(3, 6),  " ---------------------- ", "#FFFFFF");

        gui.drawText(new Position(13, 12), "Menu", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(13, 14 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#89CFF0" : "#FFFFFF");
        }
        gui.drawText(new Position(8, 24), "Insert Coin (c)", "#FFFFFF");
        gui.drawText(new Position(18, 29), "Credits: " + application.getCredits(), "#FFFFFF");
    }
}

package com.mrs.spaceship.viewer.menu;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.menu.DefeatMenu;
import com.mrs.spaceship.viewer.Viewer;

public class DefeatMenuViewer extends Viewer<DefeatMenu> {
    public DefeatMenuViewer(DefeatMenu defeatMenu) { super(defeatMenu); }

    @Override
    public void drawElements(Application application, GUI gui) {
        gui.drawText(new Position(1, 5), "YOU LOST!", "#FFFFFF");
        gui.drawText(new Position(11, 0),  "        __          ", "#FFFFFF");
        gui.drawText(new Position(11, 1),  "       /  \\       ", "#FFFFFF");
        gui.drawText(new Position(11, 2),  "      /    \\      ", "#FFFFFF");
        gui.drawText(new Position(11, 3),  "     |  ()  |      ", "#FFFFFF");
        gui.drawText(new Position(11, 4),  "     |      |      ", "#FFFFFF");
        gui.drawText(new Position(11, 5),  "     |      |      ", "#FFFFFF");
        gui.drawText(new Position(11, 6),  "     |  ()  |      ", "#FFFFFF");
        gui.drawText(new Position(11, 7),  "    /|      |\\      ", "#FFFFFF");
        gui.drawText(new Position(11, 8),  "   / |      | \\     ", "#FFFFFF");
        gui.drawText(new Position(11, 9),  "  /  |  ()  |  \\    ", "#FFFFFF");
        gui.drawText(new Position(11, 10), " /   |      |   \\   ", "#FFFFFF");
        gui.drawText(new Position(11, 11), "|    |      |    |  ", "#FFFFFF");
        gui.drawText(new Position(11, 12), "|    |      |    | ", "#FFFFFF");
        gui.drawText(new Position(11, 13), "|    |  ||  |    |", "#FFFFFF");
        gui.drawText(new Position(11, 14), "|    |  ||  |    |", "#FFFFFF");
        gui.drawText(new Position(11, 15), "|   /|  ||  |\\   |", "#FFFFFF");
        gui.drawText(new Position(11, 16), "|  | |  ||  | |  |", "#FFFFFF");
        gui.drawText(new Position(11, 17), "|  | |  ||  | |  |", "#FFFFFF");
        gui.drawText(new Position(11, 18), "|__| | /  \\ | |__|", "#FFFFFF");
        gui.drawText(new Position(11, 19), "     |/    \\|     ", "#FFFFFF");

        gui.drawText(new Position(8, 22), "Insert Coin (c)", !application.hasCredits() ? "#FF0000" :"#000000");
        gui.drawText(new Position(18, 29), "Credits: " + application.getCredits(), !application.hasCredits() ? "#FF0000" : "#FFFFFF");

        if (application.hasCredits()) {
            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                gui.drawText(new Position(1, 12 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
            }
        }
    }
}

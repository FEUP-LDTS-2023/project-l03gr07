package com.mrs.spaceship.viewer.menu;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.menu.Initial;
import com.mrs.spaceship.viewer.Viewer;

public class InitialViewer extends Viewer<Initial> {
    public InitialViewer(Initial model) {
        super(model);
    }

    @Override
    public void drawElements(Application application, GUI gui) {
        gui.drawText(new Position(3, 3),  " ----------------------", "#FFFFFF");
        gui.drawText(new Position(3, 4),  "|         SPACE        |", "#FFFFFF");
        gui.drawText(new Position(3, 5),  "|        SHOOTER       |", "#FFFFFF");
        gui.drawText(new Position(3, 6),  " ---------------------- ", "#FFFFFF");
        gui.drawText(new Position(3, 7),  "                        ", "#FFFFFF");
        gui.drawText(new Position(3, 8),  "           /\\          ", "#FFFFFF");
        gui.drawText(new Position(3, 9),  "          |()|          ", "#FFFFFF");
        gui.drawText(new Position(3, 10), " /\\       |  |       /\\", "#FFFFFF");
        gui.drawText(new Position(3, 11), " ||       |()|       ||", "#FFFFFF");
        gui.drawText(new Position(3, 12), " ||      /    \\      ||", "#FFFFFF");
        gui.drawText(new Position(3, 13), " ||     /      \\     ||", "#FFFFFF");
        gui.drawText(new Position(3, 14), " ||____/        \\____||", "#FFFFFF");
        gui.drawText(new Position(3, 15), " |         /\\         |", "#FFFFFF");
        gui.drawText(new Position(3, 16), " |         ||         |", "#FFFFFF");
        gui.drawText(new Position(3, 17), " |     ____||____     |", "#FFFFFF");
        gui.drawText(new Position(3, 18), " |    /    ||    \\    |", "#FFFFFF");
        gui.drawText(new Position(3, 19), " |   /     ||     \\   |", "#FFFFFF");
        gui.drawText(new Position(3, 20), " |  /      ||      \\  |", "#FFFFFF");
        gui.drawText(new Position(3, 21), " | /      /__\\      \\ |", "#FFFFFF");
        gui.drawText(new Position(3, 22), " |/                  \\|", "#FFFFFF");

        gui.drawText(new Position(8, 24), "Insert Coin (c)", "#FF0000");
        gui.drawText(new Position(18, 29), "Credits: " + application.getCredits(), "#FF0000");
    }
}

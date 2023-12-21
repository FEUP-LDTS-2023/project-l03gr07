package com.mrs.spaceship.viewer.menu;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.menu.InstructionsMenu;
import com.mrs.spaceship.viewer.Viewer;

public class InstructionsMenuViewer extends Viewer<InstructionsMenu> {
    public InstructionsMenuViewer(InstructionsMenu instructionsMenu) { super(instructionsMenu); }

    @Override
    public void drawElements(Application application, GUI gui) {
        gui.drawText(new Position(26, 1), getModel().getEntry(0), getModel().isSelected(0) ? "#00FF00" : "#FFFFFF");
        gui.drawText(new Position(28, 1), getModel().getEntry(1), getModel().isSelected(1) ? "#FF0000" : "#FFFFFF");
        gui.drawText(new Position(1,1), "Controls: ", "#89CFF0");
        gui.drawText(new Position(1,3), "È", "#89CFF0");
        gui.drawText(new Position(2,3), " : Move Up", "#FFFFFF");
        gui.drawText(new Position(1,5), "Ã", "#89CFF0");
        gui.drawText(new Position(2,5), " : Move Down", "#FFFFFF");
        gui.drawText(new Position(1,7), "À", "#89CFF0");
        gui.drawText(new Position(2,7), " : Move Left", "#FFFFFF");
        gui.drawText(new Position(1,9), "Â", "#89CFF0");
        gui.drawText(new Position(2,9), " : Move Right", "#FFFFFF");
        gui.drawText(new Position(1,15), "Elements: ", "#89CFF0");
        gui.drawText(new Position(1,17), "»", "#FFFFFF");
        gui.drawText(new Position(2,17), " : Our Spaceship", "#FFFFFF");
        gui.drawText(new Position(1,19), "Ó", "#FF0000");
        gui.drawText(new Position(2,19), " : Meteors", "#FFFFFF");
        gui.drawText(new Position(1,21), "Ú", "#FFC300");
        gui.drawText(new Position(2,21), " : Default Enemies", "#FFFFFF");
        gui.drawText(new Position(1,23), "Û", "#FF0FF0");
        gui.drawText(new Position(2,23), " : Special Enemies", "#FFFFFF");
        gui.drawText(new Position(1,25), "Ù", "#FFFF00");
        gui.drawText(new Position(2,25), " : Powers", "#FFFFFF");
    }
}

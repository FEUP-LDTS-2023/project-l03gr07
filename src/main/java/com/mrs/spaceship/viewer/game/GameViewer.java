package com.mrs.spaceship.viewer.game;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.elements.Element;
import com.mrs.spaceship.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) { super(arena); }

    @Override
    protected void drawElements(Application application, GUI gui) {
        drawElements(gui, getModel().getDefaultShots(), new DefaultShotsViewer());
        drawElements(gui, getModel().getDoubleShots(), new DoubleShotsViewer());
        drawElements(gui, getModel().getBurstShots(), new BurstShotsViewer());
        drawElements(gui, getModel().getTripleShots(), new TripleShotsViewer());
        drawElements(gui, getModel().getEnemyShots(), new EnemyShotsViewer());
        drawElements(gui, getModel().getPowers(), new PowerViewer());

        drawElement(gui, getModel().getSpaceship(), new SpaceshipViewer());
        drawElements(gui, getModel().getMeteors(), new MeteorViewer());
        drawElements(gui, getModel().getLimits(), new LimitViewer());
        drawElements(gui, getModel().getSpecialEnemies(), new SpecialEnemiesViewer());
        drawElements(gui, getModel().getDefaultEnemies(), new DefaultEnemiesViewer());


        gui.drawText(new Position(0, 1), "Highest", "#89CFF0");
        gui.drawText(new Position(0, 2), "Score", "#89CFF0");
        gui.drawText(new Position(0, 3), ":" + application.getHishestScore(), "#FFFFFF");
        gui.drawText(new Position(0, 10), "Current", "#89CFF0");
        gui.drawText(new Position(0, 11), "Score", "#89CFF0");
        gui.drawText(new Position(0, 12), ":" + getModel().getSpaceship().getScore(), "#FFFFFF");
        gui.drawText(new Position(0, 19), "Lives", "#89CFF0");
        gui.drawText(new Position(0, 20), ":" + getModel().getSpaceship().getEnergy(), "#FFFFFF");
        gui.drawText(new Position(0, 27), "Credits", application.hasCredits() ? "#89CFF0" : "#FF0000");
        gui.drawText(new Position(0, 28), ":" + application.getCredits(), "#FFFFFF");
    }

    private  <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) {
            drawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}

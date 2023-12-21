package com.mrs.spaceship.viewer;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.menu.Initial;
import com.mrs.spaceship.viewer.menu.InitialViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InitialMenuViewerTest {

    @Test
    void drawElement() {
        Initial initialMenu = new Initial();
        GUI gui = Mockito.mock(GUI.class);
        Application application = Mockito.mock(Application.class);
        InitialViewer initialMenuViewer = new InitialViewer(initialMenu);
        initialMenuViewer.drawElements(application, gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3, 4),  "|         SPACE        |", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3, 5),  "|        SHOOTER       |", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3, 6),  " ---------------------- ", "#FFFFFF");
    }
}

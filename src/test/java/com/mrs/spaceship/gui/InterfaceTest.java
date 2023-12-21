package com.mrs.spaceship.gui;

import com.mrs.spaceship.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;

public class InterfaceTest {
    private Screen screen;
    private Interface gui;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);
        gui = new Interface(screen);
    }

    @Test
    void drawSpaceShip() {
        gui.drawSpaceship(new Position(1, 1));

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "»");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Space Shooter", "#000000");

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Space Shooter");
    }

    @Test
    void drawPower() {
        gui.drawText(new Position(1, 1), "Ù", "#FFFF00");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Ù");

    }

    @Test
    void drawMeteor() {
        gui.drawText(new Position(1, 1), "Ó", "#FF0000");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Ó");

    }

    @Test
    void drawSpecialEnemies() {
        gui.drawText(new Position(1, 1), "Û", "#FF0FF0");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 15, 240));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Û");
    }

    @Test
    void drawDefaultEnemies() {
        gui.drawText(new Position(1, 1), "Ú", "#FFC300");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 195, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Ú");
    }

    @Test
    void drawEnemyShots() {
        gui.drawText(new Position(1, 1), ".", "#FFA500");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 165, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, ".");
    }


    @Test
    void drawDefaultShots() {
        gui.drawText(new Position(1, 1), ".", "#FFFFFF");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, ".");
    }

    @Test
    void drawDoubleShots() {
        gui.drawText(new Position(1, 1), "\"", "#FFFFFF");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "\"");
    }

    @Test
    void drawBurstShots() {
        gui.drawText(new Position(1, 1), "|", "#FFFFFF");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "|");
    }

    @Test
    void drawTripleShots() {
        gui.drawText(new Position(1, 1), ".", "#FFFFFF");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, ".");
    }

    @Test
    void drawLimits() {
        gui.drawText(new Position(1, 1), "#", "#FFFFFF");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "#");
    }
}



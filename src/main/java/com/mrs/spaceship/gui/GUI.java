package com.mrs.spaceship.gui;

import com.mrs.spaceship.model.Position;

import java.io.IOException;

public interface GUI {
    void drawSpaceship(Position position);
    void drawMeteor(Position position);
    void drawPower(Position position);
    void drawEnemyShots(Position position);
    void drawDefaultShots(Position position);
    void drawDoubleShots(Position position);
    void drawBurstShots(Position position);
    void drawTripleShots(Position position);
    void drawLimits(Position position);

    void drawDefaultEnemies(Position position);
    void drawSpecialEnemies(Position position);
    void drawText(Position position, String text, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    enum Action {UP, DOWN, LEFT, RIGHT, NONE, QUIT, SELECT, SPACE, COIN}
    Action getNextAction() throws IOException;
}

package com.mrs.spaceship.controller.menu;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.arena.ArenaBuilder;
import com.mrs.spaceship.model.menu.InstructionsMenu;
import com.mrs.spaceship.model.menu.Menu;
import com.mrs.spaceship.states.GameState;
import com.mrs.spaceship.states.InstructionsMenuState;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) { super(menu); }
    @Override
    public void step(Application application, GUI.Action action, long time) {
        if (!application.hasCredits()) {
            switch (action) {
                case SELECT:
                    application.setState(null);
                    break;
                case COIN:
                    application.addCredit();
                    break;
            }

        }
        else {
            switch (action) {
                case UP:
                    getModel().previousEntry();
                    break;
                case DOWN:
                    getModel().nextEntry();
                    break;
                case SELECT:
                    if (getModel().isSelectedExit()) application.setState(null);
                    if (getModel().isSelectedStart() && application.getCredits() > 0) {
                        application.setState(new GameState(new ArenaBuilder(30, 30).createArena()));
                        application.useCredit();
                    }
                    if (getModel().isSelectedInstructions()) application.setState(new InstructionsMenuState( new InstructionsMenu()));
                    break;
                case COIN:
                    if (application.getCredits() < 9)
                        application.addCredit();
                    break;

            }
        }
    }
}

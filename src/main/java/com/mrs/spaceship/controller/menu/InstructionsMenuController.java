package com.mrs.spaceship.controller.menu;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.menu.InstructionsMenu;
import com.mrs.spaceship.model.menu.Menu;
import com.mrs.spaceship.states.MenuState;

import java.io.IOException;

public class InstructionsMenuController extends Controller<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu instructionsMenu) { super(instructionsMenu); }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        switch (action) {
            case RIGHT:
                if (getModel().isSelectedStay()) {
                    getModel().nextEntry();
                }
                break;
            case LEFT:
                if (getModel().isSelectedExit()) {
                    getModel().previousEntry();
                }
                break;
            case SELECT:
                if (getModel().isSelectedExit()) {
                    application.setState(new MenuState(new Menu()));
                }
        }
    }
}

package com.mrs.spaceship.controller.menu;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.menu.Initial;
import com.mrs.spaceship.model.menu.Menu;
import com.mrs.spaceship.states.MenuState;

import java.io.IOException;

public class InitialController extends Controller<Initial> {
    public InitialController(Initial model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        switch (action) {
            case SELECT:
                application.setState(null);
                break;
            case COIN:
                application.setState(new MenuState(new Menu()));
                application.addCredit();
                break;
        }
    }
}

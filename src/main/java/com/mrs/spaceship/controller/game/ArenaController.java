package com.mrs.spaceship.controller.game;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.menu.DefeatMenu;
import com.mrs.spaceship.model.menu.Initial;
import com.mrs.spaceship.model.menu.Menu;
import com.mrs.spaceship.states.DefeatMenuState;
import com.mrs.spaceship.states.InitialState;
import com.mrs.spaceship.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final SpaceshipController spaceshipController;
    private final MeteorController meteorController;
    private final SpecialEnemyController specialEnemyController;
    private final DefaultEnemyController defaultEnemyController;
    private final PowerController powerController;
    public ArenaController(Arena arena) {
        super(arena);
        this.spaceshipController = new SpaceshipController(arena);
        this.meteorController = new MeteorController(arena);
        this.specialEnemyController = new SpecialEnemyController(arena);
        this.defaultEnemyController = new DefaultEnemyController(arena);
        this.powerController = new PowerController(arena);
    }
    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (getModel().getSpaceship().getScore() > application.getHishestScore())
            application.setHighestScore(getModel().getSpaceship().getScore());
        if (action == GUI.Action.QUIT) {
            getModel().getDefaultEnemyexecutorService().shutdownNow();
            getModel().getSpecialEnemyexecutorService().shutdownNow();
            getModel().getPowerTimer().cancel();
            if (application.hasCredits())
                application.setState(new MenuState(new Menu()));
            else application.setState(new InitialState(new Initial()));
        }
        else if (getModel().getSpaceship().getEnergy() == 0) {
            getModel().getDefaultEnemyexecutorService().shutdownNow();
            getModel().getSpecialEnemyexecutorService().shutdownNow();
            getModel().getPowerTimer().cancel();
            application.setState(new DefeatMenuState(new DefeatMenu()));
        }
        else {
            spaceshipController.step(application, action, time);
            meteorController.step(application, action, time);
            specialEnemyController.step(application, action, time);
            defaultEnemyController.step(application, action, time);
            powerController.step(application, action, time);
        }
    }
}

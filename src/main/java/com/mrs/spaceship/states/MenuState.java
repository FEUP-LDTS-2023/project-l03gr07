package com.mrs.spaceship.states;

import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.controller.menu.MenuController;
import com.mrs.spaceship.model.menu.Menu;
import com.mrs.spaceship.viewer.Viewer;
import com.mrs.spaceship.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() { return new MenuViewer(getModel()); }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
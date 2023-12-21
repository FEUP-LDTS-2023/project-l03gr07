package com.mrs.spaceship.states;

import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.controller.menu.DefeatMenuController;
import com.mrs.spaceship.model.menu.DefeatMenu;
import com.mrs.spaceship.viewer.Viewer;
import com.mrs.spaceship.viewer.menu.DefeatMenuViewer;

public class DefeatMenuState extends State<DefeatMenu> {
    public DefeatMenuState (DefeatMenu model) { super(model); }

    @Override
    protected Viewer<DefeatMenu> getViewer() { return new DefeatMenuViewer(getModel()); }

    @Override
    protected Controller<DefeatMenu> getController() { return new DefeatMenuController(getModel()); }
}

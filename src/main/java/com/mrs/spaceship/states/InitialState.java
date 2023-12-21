package com.mrs.spaceship.states;

import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.controller.menu.InitialController;
import com.mrs.spaceship.model.menu.Initial;
import com.mrs.spaceship.viewer.Viewer;
import com.mrs.spaceship.viewer.menu.InitialViewer;

public class InitialState extends State<Initial> {
    public InitialState(Initial model) { super(model); }
    @Override
    protected Viewer<Initial> getViewer() {
        return new InitialViewer(getModel());
    }

    @Override
    protected Controller<Initial> getController() {
        return new InitialController(getModel());
    }
}

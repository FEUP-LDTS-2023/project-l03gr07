package com.mrs.spaceship.states;

import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.controller.menu.InstructionsMenuController;
import com.mrs.spaceship.model.menu.InstructionsMenu;
import com.mrs.spaceship.viewer.Viewer;
import com.mrs.spaceship.viewer.menu.InstructionsMenuViewer;

public class InstructionsMenuState extends State<InstructionsMenu> {
    public InstructionsMenuState(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InstructionsMenu> getViewer() {
        return new InstructionsMenuViewer(getModel());
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsMenuController(getModel());
    }
}

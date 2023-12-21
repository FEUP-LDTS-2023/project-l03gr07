package com.mrs.spaceship.states;

import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.controller.game.ArenaController;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.viewer.Viewer;
import com.mrs.spaceship.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState (Arena arena) { super(arena); }

    @Override
    protected Viewer<Arena> getViewer() { return new GameViewer(getModel()); }

    @Override
    protected Controller<Arena> getController() { return new ArenaController(getModel()); }
}

package com.mrs.spaceship.controller.game;

import com.mrs.spaceship.controller.Controller;
import com.mrs.spaceship.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) { super(arena); }

}

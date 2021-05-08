package com.juubes.squarelaws;

import java.util.LinkedList;
import java.util.Random;

import com.juubes.gamestart.GameHandler;

import lombok.Getter;

public class GameHandlerImpl extends GameHandler {
    private static final Random RAND = new Random();

    private final SquareLaws game;

    @Getter
    private LinkedList<Square> tiles = new LinkedList<>();

    public GameHandlerImpl(SquareLaws game) {
	this.game = game;
    }

    @Override
    public void prepare() {
	// Before game starts

	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 10; j++) {
		tiles.add(new Square(i - 5, j - 5, RAND.nextInt()));
	    }
	}
    }

    @Override
    public void update() {
	game.getInputHandler().update();
	game.getRenderer().getCamera().update();

	// Every tick
	for (Tickable tickable : tiles) {
	    tickable.tick();
	}
    }

}

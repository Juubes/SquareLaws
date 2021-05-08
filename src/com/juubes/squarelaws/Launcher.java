package com.juubes.squarelaws;

import java.awt.Dimension;

import com.juubes.gamestart.GameSettings;

public class Launcher {

    public static void main(String[] args) {
	GameSettings settings = new GameSettings();
	settings.setScreenBorders(true);
	settings.setTargetTPS(20);
	settings.setMaxFPS(60);
	settings.setScreenSize(new Dimension(1080, 720));

	SquareLaws game = new SquareLaws(settings);

	game.setRenderer(new RendererImpl(game));
	game.setGameHandler(new GameHandlerImpl(game));
	game.setInputHandler(new InputImpl(game));

	game.start();
    }
}

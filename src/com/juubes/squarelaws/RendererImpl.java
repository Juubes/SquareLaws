package com.juubes.squarelaws;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import com.juubes.gamestart.Renderer;

import lombok.Getter;

public class RendererImpl extends Renderer {
    private final SquareLaws game;

    @Getter
    private final Camera camera;

    public RendererImpl(SquareLaws game) {
	super(game);
	this.camera = new Camera();
	this.game = game;
    }

    @Override
    public void render(Graphics2D g) {
	g.setColor(Color.red);
	g.fillRect(0, 0, game.getWidth(), game.getHeight());

	g.translate(-camera.getX(), camera.getY());
	g.translate(game.getWidth(), game.getHeight());

	for (Square tile : game.getGameHandler().getTiles()) {
	    tile.draw(g);
	}
    }
}

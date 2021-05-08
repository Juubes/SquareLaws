package com.juubes.squarelaws;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_W;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import com.juubes.gamestart.Input;

public class InputImpl extends Input {

    private final Camera camera;

    private Set<Integer> keysDown = new HashSet<>();

    public InputImpl(SquareLaws game) {
	this.camera = game.getRenderer().getCamera();
    }

    public void update() {
	for (Integer code : keysDown) {
	    switch (code) {
	    // Camera
	    case VK_W:
		camera.moveY();
		break;
	    case VK_A:
		camera.moveOppositeX();
		break;
	    case VK_S:
		camera.moveOppositeY();
		break;
	    case VK_D:
		camera.moveX();
		break;
	    }
	}
    }

    @Override
    public void keyPressed(KeyEvent e) {
	keysDown.add(e.getKeyCode());

	switch (e.getKeyCode()) {
	// End game
	case VK_ESCAPE:
	    System.exit(0);
	    break;
	case VK_Q:
	    if (e.isControlDown())
		System.exit(0);
	    break;
	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
	keysDown.remove(e.getKeyCode());
    }

}

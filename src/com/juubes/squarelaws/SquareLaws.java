package com.juubes.squarelaws;

import com.juubes.gamestart.GameSettings;
import com.juubes.gamestart.GameStart;

public class SquareLaws extends GameStart {
    static {
//	System.setProperty("sun.java2d.transaccel", "True");
//	System.setProperty("sun.java2d.trace", "timestamp,log,count");
//	System.setProperty("sun.java2d.opengl", "True");
//	System.setProperty("sun.java2d.d3d", "True");
//	System.setProperty("sun.java2d.ddforcevram", "True");
    }

    public SquareLaws(GameSettings settings) {
	super(settings);
    }

    @Override
    public GameHandlerImpl getGameHandler() {
	return (GameHandlerImpl) this.gameHandler;
    }

    @Override
    public RendererImpl getRenderer() {
	return (RendererImpl) this.renderer;
    }

    @Override
    public InputImpl getInputHandler() {
	return (InputImpl) this.inputHandler;
    }
}

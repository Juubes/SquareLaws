package com.juubes.squarelaws;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Camera {

    public static final int SLOW_DOWN_SPEED = 4;
    public static final int MOVE_SPEED_ADDITION = 8;

    @Getter
    @Setter
    private double x, y;

    @Getter
    @Setter
    private double velX, velY;

    public void moveX() {
	this.velX += MOVE_SPEED_ADDITION;
    }

    public void moveY() {
	this.velY += MOVE_SPEED_ADDITION;
    }

    public void moveOppositeX() {
	this.velX -= MOVE_SPEED_ADDITION;
    }

    public void moveOppositeY() {
	this.velY -= MOVE_SPEED_ADDITION;
    }

    public void update() {
	this.x += velX;
	this.y += velY;

	// TODO: gotta do the slowing down with a vector so it doesn't change direction
	// when user stops moving

	// Slow down
	if (this.velX > 0)
	    this.velX -= Math.min(velX, SLOW_DOWN_SPEED);

	if (this.velY > 0)
	    this.velY -= Math.min(velY, SLOW_DOWN_SPEED);

	if (this.velX < 0)
	    this.velX += Math.max(velX, SLOW_DOWN_SPEED);

	if (this.velY < 0)
	    this.velY += Math.max(velY, SLOW_DOWN_SPEED);
    }
}

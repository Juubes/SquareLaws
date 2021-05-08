package com.juubes.squarelaws;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

public class Square implements Tickable, Drawable {
    public static int WIDTH = 40, HEIGHT = 40;

    @Getter
    private final int x, y;

    @Getter
    private Color color;

    @Getter
    @Setter
    private int elementNumber = 1;

    public Square(int x, int y, int elementNumber) {
	this.x = x;
	this.y = y;
	this.elementNumber = elementNumber;

	updateElement(elementNumber);
    }

    /**
     * Sets default element number to 1.
     */
    public Square(int x, int y) {
	this.x = x;
	this.y = y;
	this.elementNumber = 1;
	updateElement(elementNumber);
    }

    public void updateElement(int elementNumber) {
	// Generates random values based on the element number.
	final Random rand = new Random(elementNumber);

	this.color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics2D g) {
	g.setColor(this.getColor());
	g.fillRect(x * WIDTH, y * HEIGHT, WIDTH, HEIGHT);
    }

}

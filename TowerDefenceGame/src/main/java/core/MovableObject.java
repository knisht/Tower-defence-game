package core;

import javafx.scene.paint.Color;

public abstract class MovableObject extends GameObject {

	double speedX;
	double speedY;

	public MovableObject(String src, double x, double y, double radius, Color color, double speedX, double speedY) {
		super(src, x, y, radius, color);
		this.speedX = speedX;
		this.speedY = speedY;
	}

	void move() {
		x += speedX;
		y += speedY;
		super.relocate(x, y);
	}

}

package core;

import javafx.scene.paint.Color;

public abstract class MovableObject extends GameObject {

	private double speedX;
	private double speedY;

	public MovableObject(String src, double x, double y, double radius, Color color, double speedX, double speedY) {
		super(src, x, y, radius, color);
		this.speedX = speedX;
		this.speedY = speedY;
	}

	void move() {
		setX(getX() + speedX);
		setY(getY() + speedY);
		super.render();
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

}

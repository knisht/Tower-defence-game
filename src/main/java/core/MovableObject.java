package core;

import core.primitive.Point;
import core.primitive.Speed;
import javafx.scene.paint.Color;

public abstract class MovableObject extends GameObject {

	private Speed speed;

	public MovableObject(String src, Point point, double radius, Color color, Speed speed) {
		super(src, point, radius, color);
		this.speed = speed;
	}

	void move() {
		setPoint(getPoint().add(speed));
		super.render();
	}

	void move(Speed speed) {
		setPoint(getPoint().add(speed));
		super.render();
	}

	public Speed getSpeed() {
		return speed;
	}

	public void setSpeed(Speed speed) {
		this.speed = speed;
	}

}

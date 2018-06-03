package core.primitive;

import javafx.geometry.Point2D;

public class Point extends Point2D{
	
	public Point(double x, double y) {
		super(x, y);
	}

	public Point add(Speed speed) {
		return new Point(super.getX() + speed.getSpeedX(), super.getY() + speed.getSpeedY());
	}
}

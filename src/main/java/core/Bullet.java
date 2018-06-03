package core;

import static core.World.*;

import core.primitive.Point;
import core.primitive.Speed;

public class Bullet extends MovableObject {

	BulletType type;
	private boolean actual = true;

	public Bullet(Point sender, Point target, BulletType type) {
		super(type.src, sender, type.radius, type.color, new Speed(
				Math.signum(target.getX() - sender.getX()) * Math
						.abs(Math.sin(Math.atan((target.getX() - sender.getX()) / (target.getY() - sender.getY())))
								* type.speed),
				Math.signum(target.getY() - sender.getY()) * Math
						.abs(Math.cos(Math.atan((target.getX() - sender.getX()) / (target.getY() - sender.getY())))
								* type.speed)));
		this.type = type;
		root.getChildren().add(this);
		super.render();
	}

	@Override
	public void move() {
		if (type.hit(getPoint()) && actual) {
			this.setVisible(false);
			bullets.remove(this);
			root.getChildren().remove(this);
			actual = false;
		} else {
			super.move();
			super.render();
		}

	}

}

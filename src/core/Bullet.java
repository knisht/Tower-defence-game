package core;

import static core.World.*;

public class Bullet extends MovableObject {

	BulletType type;

	public Bullet(double x, double y, double targetX, double targetY, BulletType type) {
		super(type.src, x, y, type.radius, type.color,
				Math.signum(targetX - x) * Math.abs(Math.sin(Math.atan((targetX - x) / (targetY - y))) * type.speed),
				Math.signum(targetY - y) * Math.abs(Math.cos(Math.atan((targetX - x) / (targetY - y))) * type.speed));
		this.type = type;
		root.getChildren().add(this);
		super.relocate(x, y);
	}

	@Override
	public void move() {
		if (type.hit(x, y)) {
			this.setVisible(false);
			bullets.remove(this);
			root.getChildren().remove(this);
		} else {
			x += speedX;
			y += speedY;
			super.relocate(x, y);
		}

	}

}

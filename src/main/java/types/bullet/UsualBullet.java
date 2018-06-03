package types.bullet;

import static core.World.enemies;

import core.BulletType;
import core.Enemy;
import core.Tower;
import core.primitive.Point;
import javafx.scene.paint.Color;

public class UsualBullet extends BulletType {

	public UsualBullet(double damage, String imageSource, Color color, double speed, double radius, String damageType) {
		super.damage = damage;
		super.imageSource = imageSource;
		super.color = color;
		super.speed = speed;
		super.radius = radius;
		super.damageType = damageType;
	}

	@Override
	public boolean hit(Point point) {
		boolean hit = false;
		for (Enemy enemy : enemies) {
			if (enemy.alive() && Tower.possibleToShoot(damageType, enemy.getFlying())
					&& enemy.getPoint().distance(point) <= enemy.getBase().getRadius()) {
				hit = true;
				break;
			}
		}
		if (hit) {
			for (Enemy enemy : enemies) {
				if (enemy.alive() && Tower.possibleToShoot(damageType, enemy.getFlying())
						&& enemy.getPoint().distance(point) <= enemy.getBase().getRadius()) {
					enemy.receiveDamage(damage);
					break;
				}
			}
			return true;
		} else {
			return false;
		}
	}

}

package types.bullet;

import static core.World.TILE_SIDE;
import static core.World.enemies;

import core.BulletType;
import core.Enemy;
import core.Tower;
import core.primitive.Point;
import javafx.scene.paint.Color;

public class SplashBullet extends BulletType {

	double range = TILE_SIDE * 2;

	public SplashBullet() {
		damage = 100;
		imageSource = "";
		color = Color.BLACK;
		speed = 2.5;
		radius = 4;
		damageType = "G";
	}

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
						&& enemy.getPoint().distance(point) <= range) {
					enemy.receiveDamage(damage);
				}
			}
			return true;
		} else {
			return false;
		}
	}
}

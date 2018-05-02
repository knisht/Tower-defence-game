package types.bullet;

import static core.World.TILE_SIDE;
import static core.World.dist;
import static core.World.enemies;

import core.BulletType;
import core.Enemy;
import core.Tower;
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

	public boolean hit(double x, double y) {
		boolean hit = false;
		for (Enemy enemy : enemies) {
			if (enemy.alive() && Tower.possibleToShoot(damageType, enemy.flying)
					&& dist(enemy.x + TILE_SIDE / 2, enemy.y + TILE_SIDE / 2, x, y) <= enemy.base.getRadius()) {
				hit = true;
				break;
			}
		}
		if (hit) {
			for (Enemy enemy : enemies) {
				if (enemy.alive() && Tower.possibleToShoot(damageType, enemy.flying)
						&& dist(enemy.x + TILE_SIDE / 2, enemy.y + TILE_SIDE / 2, x, y) <= range) {
					enemy.receiveDamage(damage);
				}
			}
			return true;
		} else {
			return false;
		}
	}
}

package types.bullet;

import static core.World.*;

import core.BulletType;
import core.Enemy;
import core.Tower;
import javafx.scene.paint.Color;

public class MiddleBullet extends BulletType {
	public MiddleBullet() {
		damage = 100 / 2;
		imageSource = "";
		color = Color.RED;
		speed = 5;
		radius = 2;
		damageType = "B";
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
						&& dist(enemy.x + TILE_SIDE / 2, enemy.y + TILE_SIDE / 2, x, y) <= enemy.base.getRadius()) {
					enemy.receiveDamage(damage);
				}
			}
			return true;
		} else {
			return false;
		}
	}
}

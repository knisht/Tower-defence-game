package types.bullet;

import static core.World.TILE_SIDE;
import static core.World.dist;
import static core.World.enemies;

import core.BulletType;
import core.Enemy;
import core.Tower;
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
	public boolean hit(double x, double y) {
		boolean hit = false;
		for (Enemy enemy : enemies) {
			if (enemy.alive() && Tower.possibleToShoot(damageType, enemy.getFlying())
					&& dist(enemy.getX() + TILE_SIDE / 2, enemy.getY() + TILE_SIDE / 2, x, y) <= enemy.getBase().getRadius()) {
				hit = true;
				break;
			}
		}
		if (hit) {
			for (Enemy enemy : enemies) {
				if (enemy.alive() && Tower.possibleToShoot(damageType, enemy.getFlying())
						&& dist(enemy.getX() + TILE_SIDE / 2, enemy.getY() + TILE_SIDE / 2, x, y) <= enemy.getBase().getRadius()) {
					enemy.receiveDamage(damage);
				}
			}
			return true;
		} else {
			return false;
		}
	}

}

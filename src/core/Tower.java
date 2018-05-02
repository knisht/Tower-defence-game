package core;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import types.cell.TowerCell;

import static core.World.*;

public class Tower extends GameObject implements EventHandler<MouseEvent> {

	double damage;
	double range;
	public long cost;
	public long cooldown;
	public long lastShoot;
	public BulletType bullet;
	boolean active;
	public TowerCell cell;
	public String damageType;

	public Tower(String src, double x, double y, Color color, double range, long cost, long cooldown, BulletType bullet,
			String damageType) {
		super(src, x, y, TILE_SIDE / 2 - 3, color);
		this.range = range;
		this.cost = cost;
		this.cooldown = cooldown;
		this.bullet = bullet;
		this.damageType = damageType;
		lastShoot = 0;
		super.relocate(x + TILE_SIDE / 2 - base.getRadius(), y + TILE_SIDE / 2 - base.getRadius());
		active = true;
		super.setOnMouseClicked(this);
	}

	public Bullet shoot(long nowtime) {
		if (!active || nowtime - lastShoot < cooldown)
			return null;
		Enemy nearest = null;
		double minrst = Double.POSITIVE_INFINITY;
		for (Enemy enemy : enemies) {
			if (enemy.alive() && possibleToShoot(damageType, enemy.flying)) {
				double rst = dist(enemy.x, enemy.y, this.x, this.y);
				if (rst < minrst) {
					nearest = enemy;
					minrst = rst;
				}
			}
		}
		if (minrst < range) {
			if (nearest.alive()) {
				lastShoot = nowtime;
				return new Bullet(x + TILE_SIDE / 2 - base.getRadius(), y + TILE_SIDE / 2 - base.getRadius(),
						nearest.x + TILE_SIDE / 2, nearest.y + TILE_SIDE / 2, bullet);
			}
		}
		return null;
	}

	public void destroy() {
		active = false;
		relocate(10000, 10000);
		setVisible(false);
		root.getChildren().remove(this);
		towers.remove(this);
	}

	@Override
	public void handle(MouseEvent event) {
		cell.handle(event);
	}

	public static boolean possibleToShoot(String type, String flying) {
		if (type == "B" || flying == "B")
			return true;
		return (type.equals(flying));
	}

}

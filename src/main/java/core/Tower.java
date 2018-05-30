package core;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import types.cell.TowerCell;

import static core.World.*;

public class Tower extends GameObject implements EventHandler<MouseEvent> {

	private final double range;
	private final long cost;
	private final long cooldown;
	private BulletType bullet;
	private final String damageType;
	private long lastShoot;
	public boolean active;
	private TowerCell cell;

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
			if (enemy.alive() && possibleToShoot(damageType, enemy.getFlying())) {
				double rst = dist(enemy.getX(), enemy.getY(), this.getX(), this.getY());
				if (rst < minrst) {
					nearest = enemy;
					minrst = rst;
				}
			}
		}
		if (minrst < range) {
			if (nearest.alive()) {
				lastShoot = nowtime;
				return new Bullet(getX() + TILE_SIDE / 2 - base.getRadius(), getY() + TILE_SIDE / 2 - base.getRadius(),
						nearest.getX() + TILE_SIDE / 2, nearest.getY() + TILE_SIDE / 2, bullet);
			}
		}
		return null;
	}

	public void destroy() {
		active = false;
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

	public double getRange() {
		return range;
	}

	public long getCost() {
		return cost;
	}

	public long getCooldown() {
		return cooldown;
	}

	public long getLastShoot() {
		return lastShoot;
	}

	public void setLastShoot(long lastShoot) {
		this.lastShoot = lastShoot;
	}

	public BulletType getBullet() {
		return bullet;
	}

	public void setBullet(BulletType bullet) {
		this.bullet = bullet;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public TowerCell getCell() {
		return cell;
	}

	public void setCell(TowerCell cell) {
		this.cell = cell;
	}

	public String getDamageType() {
		return damageType;
	}

	
}

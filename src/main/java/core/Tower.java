package core;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import types.cell.TowerCell;

import static core.World.*;

import java.time.Duration;
import java.time.Instant;

import core.primitive.Point;

public class Tower extends GameObject implements EventHandler<MouseEvent> {

	private final double range;
	private final long cost;
	private final Duration cooldown;
	private final BulletType bullet;
	private Instant lastShoot;
	public boolean active;
	private TowerCell cell;

	public Tower(String src, Point point, Color color, double range, long cost, Duration cooldown, BulletType bullet) {
		super(src, point, TILE_SIDE / 2 - 3, color);
		this.range = range;
		this.cost = cost;
		this.cooldown = cooldown;
		this.bullet = bullet;
		lastShoot = Instant.now();
		super.relocate(point.getX() + TILE_SIDE / 2 - base.getRadius(),
				point.getY() + TILE_SIDE / 2 - base.getRadius());
		active = true;
		super.setOnMouseClicked(this);
	}

	public Bullet shoot(Instant nowtime) {
		if (!active || Duration.between(lastShoot, nowtime).toNanos() < cooldown.toNanos())
			return null;
		Enemy nearest = null;
		double minrst = Double.POSITIVE_INFINITY;
		for (Enemy enemy : enemies) {
			if (enemy.alive() && possibleToShoot(bullet.damageType, enemy.getFlying())) {
				double rst = this.getPoint().distance(enemy.getPoint());
				if (rst < minrst) {
					nearest = enemy;
					minrst = rst;
				}
			}
		}
		if (minrst < range) {
			if (nearest.alive()) {
				lastShoot = nowtime;
				return new Bullet(getPoint(), nearest.getPoint(), bullet);
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

	public Duration getCooldown() {
		return cooldown;
	}

	public BulletType getBullet() {
		return bullet;
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
}

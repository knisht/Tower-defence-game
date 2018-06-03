package core;

import javafx.scene.paint.Color;
import static core.World.*;

import core.primitive.Point;

public class Bomb extends GameObject {

	final private double damage;
	final private double splashArea;
	final private long cost;

	public Bomb(String src, Point point, Color color, double damage, double splashArea, long cost) {
		super(src, point, 3, color);
		this.damage = damage;
		this.splashArea = splashArea;
		this.cost = cost;
	}

	public void explode() {
		for (Enemy enemy : enemies) {
			if (getPoint().distance(enemy.getPoint()) < enemy.base.getRadius()) {
				enemy.receiveDamage(damage);
			}
		}
	}

	public long getCost() {
		return cost;
	}

	public double getSplashArea() {
		return splashArea;
	}

	public double getDamage() {
		return damage;
	}
}

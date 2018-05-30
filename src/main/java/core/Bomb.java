package core;

import javafx.scene.paint.Color;
import static core.World.*;

public class Bomb extends GameObject {

	final private double damage;
	final private double splashArea;
	final private long cost;


	public Bomb(String src, double x, double y, Color color, double damage, double splashArea, long cost) {
		super(src, x, y, 3, color);
		this.damage = damage;
		this.splashArea = splashArea;
		this.cost = cost;
	}

	public void explode() {
		for (Enemy enemy : enemies) {
			if (dist(enemy.getX(), enemy.getY(), this.getX(), this.getY()) < enemy.base.getRadius()) {
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

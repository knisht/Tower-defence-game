package core;

import javafx.scene.paint.Color;
import static core.World.*;

public class Bomb extends GameObject {

	final protected double damage;
	final protected double splashArea;
	final protected long cost;

	public Bomb(String src, double x, double y, Color color, double damage, double splashArea, long cost) {
		super(src, x, y, 3, color);
		this.damage = damage;
		this.splashArea = splashArea;
		this.cost = cost;
	}

	public void explode() {
		for (Enemy enemy : enemies) {
			if (dist(enemy.x, enemy.y, this.x, this.y) < enemy.base.getRadius()) {
				enemy.receiveDamage(damage);
			}
		}
	}
	
	public long getCost() {
		return cost;
	}

}

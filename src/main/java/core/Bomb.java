package core;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import static core.World.*;

import core.primitive.Point;

public class Bomb extends GameObject {

	final private double damage;
	final private double splashArea;
	final private long cost;
	final private String burstSrc;
	private ImageView burst = null;
	private double alpha = 0.97;
	private double current = 1;


	public Bomb(String src, String burstSrc, Point point, Color color, double damage, double splashArea, long cost) {
		super(src, point, 3, color);
		this.damage = damage;
		this.splashArea = splashArea;
		this.cost = cost;
		this.burstSrc = burstSrc;
	}

	public void explode() {
		for (Enemy enemy : enemies) {
			if (getPoint().distance(enemy.getPoint()) < splashArea) {
				enemy.receiveDamage(damage);
			}
		}
		burst = new ImageView(Maps.getImage(burstSrc));
		burst.setFitHeight(splashArea);
		burst.setFitWidth(splashArea);
		burst.setMouseTransparent(true);
		burst.relocate(getPoint().getX()-splashArea/2, getPoint().getY()-splashArea/2);
		bombs.add(this);
		root.getChildren().add(this);
		root.getChildren().add(burst);
	}

	public void burn() {
		burst.setOpacity(current);
		current*=alpha;
		if (current<0.00001) {
			root.getChildren().remove(burst);
			root.getChildren().remove(this);
			bombs.remove(this);
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

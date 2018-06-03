package types.enemy;

import core.Enemy;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static core.World.*;


public class HealEnemy extends Enemy {

	private double healRadius;
	private double healAmount;
	public long cooldown;
	public long lastheal;
	public Circle showRange;
	static String src = "wasp.png";

	static {
		Maps.storeImage(src);
	}

	public HealEnemy(Point point) {
		super(src, point, Color.ROSYBROWN, 100, ((double) TILE_SIDE) / 30, "B");
		this.healRadius = TILE_SIDE * 3;
		this.healAmount = 50;
		this.cooldown = 1_500_000_000L;
		showRange = new Circle(point.getX(), point.getX(), healRadius, Color.YELLOWGREEN);
		showRange.setOpacity(0.5);
		root.getChildren().add(showRange);
		showRange.setVisible(false);
		showRange.setMouseTransparent(true);
	}

	@Override
	public void specialMechanic(long now) {
		showRange.setVisible(true);
		showRange.relocate(getPoint().getX()- healRadius, getPoint().getY() - healRadius);
		if (now - lastheal > cooldown) {
			lastheal = now;
			for (Enemy enemy : enemies) {
				if (enemy.alive() && getPoint().distance(enemy.getPoint()) <= healRadius) {
					enemy.setHitpoints(Math.min(enemy.maximumHitpoints, enemy.getHitpoints() + healAmount));
				}
			}
		}
	}

	@Override
	public void destroyMechanics() {
		showRange.setVisible(false);
	}

}

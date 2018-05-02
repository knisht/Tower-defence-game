package types.enemy;

import core.Enemy;
import core.Maps;
import javafx.scene.paint.Color;
import static core.World.*;


public class WeakEnemy extends Enemy {
	private static final String src = "spider.png";

	static {
		Maps.storeImage(src);
	}

	public WeakEnemy(double x, double y) {
		super(src, x, y, Color.AQUA, 100, ((double) TILE_SIDE) / 30, "G");
	}

	@Override
	public void specialMechanic(long now) {
		// Just usual enemy
	}

	@Override
	public void destroyMechanics() {
		// Just usual enemy
	}
}

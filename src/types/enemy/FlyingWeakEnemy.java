package types.enemy;

import core.Enemy;
import core.Maps;
import javafx.scene.paint.Color;
import static core.World.*;


public class FlyingWeakEnemy extends Enemy {
	private static final String src = "fly.png";

	static {
		Maps.storeImage(src);
	}

	public FlyingWeakEnemy(double x, double y) {
		super(src, x, y, Color.NAVAJOWHITE, 100, ((double) TILE_SIDE) / 30, "F");
	}

	@Override
	public void specialMechanic(long now) {
		// Just usual enemy(but it flies!)
	}

	@Override
	public void destroyMechanics() {
		// Just usual enemy
	}

}

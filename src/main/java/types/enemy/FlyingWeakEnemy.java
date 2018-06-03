package types.enemy;

import core.Enemy;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;
import static core.World.*;


public class FlyingWeakEnemy extends Enemy {
	private static final String src = "fly.png";

	static {
		Maps.storeImage(src);
	}

	public FlyingWeakEnemy(Point point) {
		super(src, point, Color.NAVAJOWHITE, 100, ((double) TILE_SIDE) / 30, "F");
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

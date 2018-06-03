package types.enemy;

import core.Enemy;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;
import static core.World.*;


public class FastEnemy extends Enemy {

	private static final String src = "fast.png";

	static {
		Maps.storeImage(src);
	}

	public FastEnemy(Point point) {
		super(src, point, Color.NAVY, 50, ((double) TILE_SIDE) / 15, "G");
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

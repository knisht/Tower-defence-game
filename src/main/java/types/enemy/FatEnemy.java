package types.enemy;

import static core.World.TILE_SIDE;


import core.Enemy;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;

public class FatEnemy extends Enemy {
	private static final String src = "fat.png";

	static {
		Maps.storeImage(src);
	}

	public FatEnemy(Point point) {
		super(src, point, Color.LIMEGREEN, 500, ((double) TILE_SIDE) / 50, "G");
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

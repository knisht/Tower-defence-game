package types.enemy;

import static core.World.TILE_SIDE;


import core.Enemy;
import core.Maps;
import javafx.scene.paint.Color;

public class FatEnemy extends Enemy {
	private static final String src = "fat.png";

	static {
		Maps.storeImage(src);
	}

	public FatEnemy(double x, double y) {
		super(src, x, y, Color.LIMEGREEN, 500, ((double) TILE_SIDE) / 50, "G");
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

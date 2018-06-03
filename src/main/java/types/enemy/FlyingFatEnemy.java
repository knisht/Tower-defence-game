package types.enemy;

import core.Enemy;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;
import static core.World.*;


public class FlyingFatEnemy extends Enemy {
	private static final String src = "flyingfat.png";

	static {
		Maps.storeImage(src);
	}

	public FlyingFatEnemy(Point point) {
		super(src, point, Color.LIME, 400, ((double) TILE_SIDE) / 50, "F");
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

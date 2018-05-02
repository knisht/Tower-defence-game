package types.enemy;

import core.Enemy;
import core.Maps;
import javafx.scene.paint.Color;
import static core.World.*;


public class FlyingFastEnemy extends Enemy {
	private static final String src = "flyingfast.png";
	
	static {
		Maps.storeImage(src);
	}
	
	public FlyingFastEnemy(double x, double y) {
		super(src, x, y, Color.NAVY, 50, ((double) TILE_SIDE) / 15, "F");
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

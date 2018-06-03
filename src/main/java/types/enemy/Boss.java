package types.enemy;

import core.Enemy;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;
import static core.World.*;

public class Boss extends Enemy {

	private double healAmount;
	public long cooldown;
	public long lastheal;

	private static final String src = "boss.png";

	static {
		Maps.storeImage(src);
	}

	public Boss(Point point) {
		super(src, point, Color.BLACK, 1000, ((double) TILE_SIDE) / 60, "B");
		healAmount = 100;
		cooldown = 1_000_000_000L;
		lastheal = 0;
	}

	@Override
	public void specialMechanic(long now) {
		if (now - lastheal > cooldown) {
			lastheal = now;
			setHitpoints(getHitpoints() + healAmount);
		}
	}

	@Override
	public void destroyMechanics() {
		// TODO Auto-generated method stub
	}

}

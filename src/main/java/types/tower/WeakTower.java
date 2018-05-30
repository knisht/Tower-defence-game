package types.tower;

import core.BulletType;
import core.Maps;
import core.Tower;
import static core.World.*;


import javafx.scene.paint.Color;
import types.bullet.WeakBullet;

public class WeakTower extends Tower {

	public static final Color color = Color.YELLOW;
	public static final long cooldown = 2_000_000_000L;
	public static final double range = TILE_SIDE * 2;
	public static final long cost = 10;
	public static final BulletType bullet = new WeakBullet();
	
	public static final String src = "weaktower.png";
	static {
		Maps.storeImage(src);
	}

	public WeakTower(double x, double y) {
		super(src, x, y, color, range, cost, cooldown, bullet, "B");
	}
}

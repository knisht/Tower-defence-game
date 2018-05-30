package types.tower;

import core.BulletType;
import core.Maps;
import core.Tower;
import javafx.scene.paint.Color;
import types.bullet.WeakUpgrFlyingBullet;

import static core.World.TILE_SIDE;


public class WeakUpgrFlyingTower extends Tower {

	public static final Color color = Color.FORESTGREEN;
	public static final long cooldown = 500_000_000L;
	public static final double range = TILE_SIDE * 2;
	public static final long cost = 20;
	public static final BulletType bullet = new WeakUpgrFlyingBullet();

	public static final String src = "flyingupgrtower.png";
	static {
		Maps.storeImage(src);
	}

	public WeakUpgrFlyingTower(double x, double y) {
		super(src, x, y, color, 100, 20, cooldown, bullet, "F");
	}

}

package types.tower;

import core.BulletType;
import core.Maps;
import core.Tower;
import core.primitive.Point;
import javafx.scene.paint.Color;
import types.bullet.SniperBullet;

import static core.World.*;



public class SniperTower extends Tower {

	public static final Color color = Color.DEEPSKYBLUE;
	public static final long cooldown = 3_000_000_000L;
	public static final double range = TILE_SIDE * 10;
	public static final long cost = 60;
	public static final BulletType bullet = new SniperBullet();

	public static final String src = "snipertower.png";
	static {
		Maps.storeImage(src);
	}
	public SniperTower(Point point) {
		super(src, point, color, range, cost, cooldown, bullet);
	}
}

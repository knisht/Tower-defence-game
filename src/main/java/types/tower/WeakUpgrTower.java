package types.tower;

import core.BulletType;
import core.Maps;
import core.Tower;
import core.primitive.Point;
import javafx.scene.paint.Color;
import types.bullet.WeakUpgrBullet;
import static core.World.TILE_SIDE;

import java.time.Duration;


public class WeakUpgrTower extends Tower {

	public static final Color color = Color.GOLDENROD;
	public static final Duration cooldown = Duration.ofNanos(500_000_000L);
	public static final double range = TILE_SIDE * 2;
	public static final long cost = 20;
	public static final BulletType bullet = new WeakUpgrBullet();
	
	
	public static final String src = "weakupgrtower.png";
	static {
		Maps.storeImage(src);
	}

	public WeakUpgrTower(Point point) {
		super(src, point, color, range, cost, cooldown, bullet);
	}

}

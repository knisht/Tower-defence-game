package types.tower;

import core.BulletType;
import core.Maps;
import core.Tower;
import core.primitive.Point;
import javafx.scene.paint.Color;
import types.bullet.MiddleBullet;
import static core.World.*;

import java.time.Duration;


public class MiddleTower extends Tower {

	public static final Color color = Color.DARKRED;
	public static final Duration cooldown = Duration.ofNanos(4_000_000_000L);
	public static final double range = TILE_SIDE * 5;
	public static final long cost = 50;
	public static final BulletType bullet = new MiddleBullet();

	public static final String src = "middletower.png";
	static {
		Maps.storeImage(src);
	}

	public MiddleTower(Point point) {
		super(src, point, color, range, cost, cooldown, bullet);
	}
}

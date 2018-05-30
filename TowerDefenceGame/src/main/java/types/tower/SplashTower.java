package types.tower;

import core.BulletType;
import core.Maps;
import core.Tower;
import javafx.scene.paint.Color;
import types.bullet.SplashBullet;

import static core.World.*;


public class SplashTower extends Tower {

	public static final Color color = Color.DARKBLUE;
	public static final long cooldown = 3_000_000_000L;
	public static final double range = TILE_SIDE * 3;
	public static final long cost = 60;
	public static final BulletType bullet = new SplashBullet();

	public static final String src = "splashtower.png";
	static {
		Maps.storeImage(src);
	}

	public SplashTower(double x, double y) {
		super(src, x, y, color, range, cost, cooldown, bullet, "B");
	}
}

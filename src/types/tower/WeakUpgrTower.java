package types.tower;

import core.BulletType;
import core.Maps;
import core.Tower;
import javafx.scene.paint.Color;
import types.bullet.WeakUpgrBullet;
import static core.World.TILE_SIDE;


public class WeakUpgrTower extends Tower {

	public static final Color color = Color.GOLDENROD;
	public static final long cooldown = 500_000_000L;
	public static final double range = TILE_SIDE * 2;
	public static final long cost = 20;
	public static final BulletType bullet = new WeakUpgrBullet();
	
	
	public static final String src = "weakupgrtower.png";
	static {
		Maps.storeImage(src);
	}

	public WeakUpgrTower(double x, double y) {
		super(src, x, y, color, 100, 20, cooldown, bullet, "G");
	}

}

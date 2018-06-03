package types.bomb;

import core.Bomb;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;
import static core.World.*;


public class BigBomb extends Bomb {

	public static final Color color = Color.DARKCYAN;
	public static final double damage = 200;
	public static final double splashArea = TILE_SIDE*4;
	public static final long cost = 100;
	public static String src = "atomic.png";
	public static String burstSrc = "nuclear.png";

	static {
		Maps.storeImage(src);
		Maps.storeImage(burstSrc);
	}

	public BigBomb(Point point) {
		super(src, burstSrc, point, color, damage, splashArea, cost);
	}

}

package types.bomb;

import core.Bomb;
import core.Maps;
import javafx.scene.paint.Color;
import static core.World.*;


public class BigBomb extends Bomb {

	public static final Color color = Color.DARKCYAN;
	public static final double damage = 200;
	public static final double splashArea = TILE_SIDE;
	public static final long cost = 100;
	public static final String src = "atomic.png";

	static {
		Maps.storeImage(src);
	}

	public BigBomb(double x, double y) {
		super(src, x, y, color, damage, splashArea, cost);
	}

}

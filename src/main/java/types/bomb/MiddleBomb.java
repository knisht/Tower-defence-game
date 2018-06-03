package types.bomb;

import core.Bomb;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;
import static core.World.*;


public class MiddleBomb extends Bomb {

	public static final Color color = Color.STEELBLUE;
	public static final double damage = 100;
	public static final double splashArea = TILE_SIDE;
	public static final long cost = 60;
	public static String src = "heat.png";

	static {
		Maps.storeImage(src);
	}

	public MiddleBomb(Point point) {
		super(src, point, color, damage, splashArea, cost);
	}

}

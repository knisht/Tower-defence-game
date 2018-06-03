package types.bomb;

import core.Bomb;
import core.Maps;
import core.primitive.Point;
import javafx.scene.paint.Color;
import static core.World.*;


public class SmallBomb extends Bomb {

	public static final Color color = Color.INDIGO;
	public static final double damage = 50;
	public static final double splashArea = TILE_SIDE;
	public static final long cost = 30;
	
	public static String src = "grenade.png";
	static {
		Maps.storeImage(src);
	}

	public SmallBomb(Point point) {
		super(src, point, color, damage, splashArea, cost);
	}

}

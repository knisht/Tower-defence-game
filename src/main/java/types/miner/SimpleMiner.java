package types.miner;


import core.Maps;
import core.Miner;
import core.primitive.Point;
import javafx.scene.paint.Color;

public class SimpleMiner extends Miner {

	public static long cost = 15;
	public static long income = 10;
	public static Color color = Color.ORANGERED;
	public static final String src = "newminer.png";

	static {
		Maps.storeImage(src);
	}

	public SimpleMiner(Point point) {
		super(src, point, color, income, cost);
	}

}

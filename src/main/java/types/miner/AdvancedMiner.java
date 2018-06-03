package types.miner;

import core.Maps;
import core.Miner;
import core.primitive.Point;
import javafx.scene.paint.Color;

public class AdvancedMiner extends Miner {

	public static long cost = 30;
	public static long income = 20;
	public static Color color = Color.ORANGE;
	public static final String src = "profminer.png";

	static {
		Maps.storeImage(src);
	}

	public AdvancedMiner(Point point) {
		super(src, point, color, income, cost);
	}

}
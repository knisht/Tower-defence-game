package types.miner;


import core.Maps;
import core.Miner;
import javafx.scene.paint.Color;

public class GreatMiner extends Miner {

	public static long cost = 70;
	public static long income = 50;
	public static Color color = Color.DEEPSKYBLUE;
	public static final String src = "dwarf.png";

	static {
		Maps.storeImage(src);
	}

	public GreatMiner(double x, double y) {
		super(src, x, y, color, income, cost);
	}

}
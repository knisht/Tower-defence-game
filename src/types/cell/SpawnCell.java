package types.cell;

import core.Maps;
import javafx.scene.paint.Color;

public class SpawnCell extends RoadCell {

	private static final double speedRate = 1;

	static String src = "cave.png";

	static {
		Maps.storeImage(src);
	}

	public SpawnCell(int wIndex, int hIndex) {
		super(src, wIndex, hIndex, Color.CADETBLUE, speedRate);
	}
}

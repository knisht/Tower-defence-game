package types.cell;

import core.Maps;
import javafx.scene.paint.Color;

public class StraightRoadCell extends RoadCell {

	private static final double speedRate = 1;

	private static final String src = "grass.jpg";

	static {
		Maps.storeImage(src);
	}
	public StraightRoadCell(int wIndex, int hIndex) {
		super(src, wIndex, hIndex, Color.GREEN, speedRate);
	}

}

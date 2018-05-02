package types.cell;

import core.Maps;
import javafx.scene.paint.Color;

public class SandRoadCell extends RoadCell {

	private static final double speedRate = 0.6;

	private static final String src = "sand.jpg";

	static {
		Maps.storeImage(src);
	}

	public SandRoadCell(int wIndex, int hIndex) {
		super(src, wIndex, hIndex, Color.GREENYELLOW, speedRate);
	}
}

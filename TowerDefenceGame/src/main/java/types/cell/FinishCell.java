package types.cell;

import core.Maps;
import javafx.scene.paint.Color;

public class FinishCell extends RoadCell {
	private static final String src = "orb.png";
	
	static {
		Maps.storeImage(src);
	}
	
	public FinishCell(int wIndex, int hIndex) {
		super(src, wIndex, hIndex, Color.RED, 1);
	}
}

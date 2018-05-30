package types.cell;

import core.Cell;
import javafx.scene.paint.Color;

public class ObstacleCell extends Cell {
	public ObstacleCell(int wIndex, int hIndex) {
		super(null, wIndex, hIndex, Color.TRANSPARENT, false);
	}
}

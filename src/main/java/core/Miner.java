package core;

import javafx.scene.paint.Color;
import types.cell.MinerCell;
import static core.World.*;

public class Miner extends MovableObject {

	public Color color;
	public long cost;
	public MinerCell cell;
	public long income;

	public Miner(String src, double x, double y, Color color, long income, long cost) {
		super(src, x, y, TILE_SIDE / 2, color, 0, 0);
		this.income = income;
		this.cost = cost;
		this.setMouseTransparent(true);
		super.relocate(x + TILE_SIDE / 2 - base.getRadius(), y + TILE_SIDE / 2 - base.getRadius());
	}

	public void destroy() {
		goldIncome -= income;
		relocate(10000, 10000);
		setVisible(false);
		miners.remove(this);
		root.getChildren().remove(this);
	}


}

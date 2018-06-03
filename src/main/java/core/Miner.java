package core;

import javafx.scene.paint.Color;
import types.cell.MinerCell;
import static core.World.*;

import core.primitive.Point;
import core.primitive.Speed;

public class Miner extends MovableObject {

	public Color color;
	public long cost;
	public MinerCell cell;
	public long income;

	public Miner(String src, Point point, Color color, long income, long cost) {
		super(src, point, TILE_SIDE / 2, color, new Speed(0, 0));
		this.income = income;
		this.cost = cost;
		this.setMouseTransparent(true);
		super.render();
	}

	public void destroy() {
		goldIncome -= income;
		relocate(10000, 10000);
		setVisible(false);
		miners.remove(this);
		root.getChildren().remove(this);
	}

}

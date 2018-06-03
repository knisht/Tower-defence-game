package ui.description;

import core.Bomb;
import core.Miner;
import core.primitive.Point;
import types.bomb.MiddleBomb;
import types.miner.SimpleMiner;
import ui.BuildDescription;

public class SimpleMinerDescription extends BuildDescription<Miner> {

	public SimpleMinerDescription() {
		super(SimpleMiner.src, "Newbie miner", "Cost: " + SimpleMiner.cost, "Income: " + SimpleMiner.income);
	}

	@Override
	public Miner forge(Point point) {
		return new SimpleMiner(point);
	}

}

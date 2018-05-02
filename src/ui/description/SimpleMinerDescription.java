package ui.description;

import core.Miner;
import types.miner.SimpleMiner;
import ui.BuildDescription;

public class SimpleMinerDescription extends BuildDescription<Miner> {

	public SimpleMinerDescription() {
		super(SimpleMiner.src, "Newbie miner", "Cost: " + SimpleMiner.cost, "Income: " + SimpleMiner.income);
	}

	@Override
	public Miner forge(double x, double y) {
		return new SimpleMiner(x, y);
	}

}

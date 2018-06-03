package ui.description;

import core.Miner;
import core.primitive.Point;
import types.miner.AdvancedMiner;
import ui.BuildDescription;

public class AdvancedMinerDescription extends BuildDescription<Miner> {

	public AdvancedMinerDescription() {
		super(AdvancedMiner.src, "Advanced miner", "Cost: "+AdvancedMiner.cost, "Income: "+ AdvancedMiner.income);
	}


	@Override
	public Miner forge(Point point) {
		return new AdvancedMiner(point);
	}



}

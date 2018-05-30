package ui.description;

import core.Miner;
import types.miner.AdvancedMiner;
import ui.BuildDescription;

public class AdvancedMinerDescription extends BuildDescription<Miner> {

	public AdvancedMinerDescription() {
		super(AdvancedMiner.src, "Advanced miner", "Cost: "+AdvancedMiner.cost, "Income: "+ AdvancedMiner.income);
	}


	@Override
	public Miner forge(double x, double y) {
		return new AdvancedMiner(x, y);
	}



}

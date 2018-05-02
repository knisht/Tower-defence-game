package ui.description;

import core.Miner;
import types.miner.GreatMiner;
import ui.BuildDescription;

public class GreatMinerDescription extends BuildDescription<Miner> {

	public GreatMinerDescription() {
		super(GreatMiner.src, "Dwarf", "Cost: "+GreatMiner.cost, "Income: "+ GreatMiner.income);
	}


	@Override
	public Miner forge(double x, double y) {
		return new GreatMiner(x, y);
	}



}

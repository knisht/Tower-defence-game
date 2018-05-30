package ui.description;

import core.Tower;
import types.tower.MiddleTower;
import ui.BuildDescription;

public class MiddleTowerDescription extends BuildDescription<Tower> {
	public MiddleTowerDescription() {
		super(MiddleTower.src, "Medium tower", "Cost: " + MiddleTower.cost, "Damage: " + MiddleTower.bullet.damage,
				"Range: " + MiddleTower.range);
	}

	@Override
	public MiddleTower forge(double x, double y) {
		return new MiddleTower(x, y);
	}
}

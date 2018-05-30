package ui.description;

import core.Tower;
import types.tower.WeakUpgrTower;
import ui.BuildDescription;

public class WeakUpgrDescription extends BuildDescription<Tower> {
	public WeakUpgrDescription() {
		super(WeakUpgrTower.src, "Ground shooter", "Cost: " + WeakUpgrTower.cost, "Damage: " + WeakUpgrTower.bullet.damage,
				"Range: " + WeakUpgrTower.range);
	}

	@Override
	public WeakUpgrTower forge(double x, double y) {
		return new WeakUpgrTower(x, y);
	}
}

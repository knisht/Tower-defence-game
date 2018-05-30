package ui.description;

import core.Tower;
import types.tower.WeakUpgrFlyingTower;
import ui.BuildDescription;

public class WeakUpgrFlyingDescription extends BuildDescription<Tower> {
	public WeakUpgrFlyingDescription() {
		super(WeakUpgrFlyingTower.src, "Air shooter", "Cost: " + WeakUpgrFlyingTower.cost, "Damage: " + WeakUpgrFlyingTower.bullet.damage,
				"Range: " + WeakUpgrFlyingTower.range);
	}

	@Override
	public WeakUpgrFlyingTower forge(double x, double y) {
		return new WeakUpgrFlyingTower(x, y);
	}
}

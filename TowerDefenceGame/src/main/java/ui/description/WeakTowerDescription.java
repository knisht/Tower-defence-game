package ui.description;

import core.Tower;
import types.tower.WeakTower;
import ui.BuildDescription;

public class WeakTowerDescription extends BuildDescription<Tower> {
	public WeakTowerDescription() {
		super(WeakTower.src, "Weak tower", "Cost: " + WeakTower.cost, "Damage: " + WeakTower.bullet.damage,
				"Range: " + WeakTower.range);
	}

	@Override
	public WeakTower forge(double x, double y) {
		return new WeakTower(x, y);
	}
}

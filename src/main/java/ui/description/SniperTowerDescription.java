package ui.description;

import core.Tower;
import types.tower.SniperTower;
import ui.BuildDescription;

public class SniperTowerDescription extends BuildDescription<Tower> {
	public SniperTowerDescription() {
		super(SniperTower.src, "Medium tower", "Cost: " + SniperTower.cost, "Damage: " + SniperTower.bullet.damage,
				"Range: " + SniperTower.range);
	}

	@Override
	public SniperTower forge(double x, double y) {
		return new SniperTower(x, y);
	}
}

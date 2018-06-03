package ui.description;

import core.Tower;
import core.primitive.Point;
import types.tower.WeakUpgrTower;
import ui.BuildDescription;

public class WeakUpgrDescription extends BuildDescription<Tower> {
	public WeakUpgrDescription() {
		super(WeakUpgrTower.src, "Ground shooter", "Cost: " + WeakUpgrTower.cost, "Damage: " + WeakUpgrTower.bullet.damage,
				"Range: " + WeakUpgrTower.range);
	}

	@Override
	public Tower forge(Point point) {
		return new WeakUpgrTower(point);
	}
}

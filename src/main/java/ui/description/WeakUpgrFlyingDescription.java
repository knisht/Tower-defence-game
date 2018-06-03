package ui.description;

import core.Tower;
import core.primitive.Point;
import types.tower.WeakUpgrFlyingTower;
import ui.BuildDescription;

public class WeakUpgrFlyingDescription extends BuildDescription<Tower> {
	public WeakUpgrFlyingDescription() {
		super(WeakUpgrFlyingTower.src, "Air shooter", "Cost: " + WeakUpgrFlyingTower.cost, "Damage: " + WeakUpgrFlyingTower.bullet.damage,
				"Range: " + WeakUpgrFlyingTower.range);
	}

	@Override
	public Tower forge(Point point) {
		return new WeakUpgrFlyingTower(point);
	}
}

package ui.description;

import core.Bomb;
import core.Tower;
import core.primitive.Point;
import types.bomb.MiddleBomb;
import types.tower.WeakTower;
import ui.BuildDescription;

public class WeakTowerDescription extends BuildDescription<Tower> {
	public WeakTowerDescription() {
		super(WeakTower.src, "Weak tower", "Cost: " + WeakTower.cost, "Damage: " + WeakTower.bullet.damage,
				"Range: " + WeakTower.range);
	}

	@Override
	public Tower forge(Point point) {
		return new WeakTower(point);
	}
}

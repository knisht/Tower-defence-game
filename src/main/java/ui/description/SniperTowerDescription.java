package ui.description;

import core.Bomb;
import core.Tower;
import core.primitive.Point;
import types.bomb.MiddleBomb;
import types.tower.SniperTower;
import ui.BuildDescription;

public class SniperTowerDescription extends BuildDescription<Tower> {
	public SniperTowerDescription() {
		super(SniperTower.src, "Medium tower", "Cost: " + SniperTower.cost, "Damage: " + SniperTower.bullet.damage,
				"Range: " + SniperTower.range);
	}

	@Override
	public Tower forge(Point point) {
		return new SniperTower(point);
	}
}

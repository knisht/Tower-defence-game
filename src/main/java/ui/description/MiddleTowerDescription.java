package ui.description;

import core.Bomb;
import core.Tower;
import core.primitive.Point;
import types.bomb.MiddleBomb;
import types.tower.MiddleTower;
import ui.BuildDescription;

public class MiddleTowerDescription extends BuildDescription<Tower> {
	public MiddleTowerDescription() {
		super(MiddleTower.src, "Medium tower", "Cost: " + MiddleTower.cost, "Damage: " + MiddleTower.bullet.damage,
				"Range: " + MiddleTower.range);
	}

	@Override
	public Tower forge(Point point) {
		return new MiddleTower(point);
	}
}

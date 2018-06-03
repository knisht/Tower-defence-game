package ui.description;

import core.Bomb;
import core.primitive.Point;
import types.bomb.SmallBomb;
import ui.BuildDescription;

public class SmallBombDescription extends BuildDescription<Bomb> {

	public SmallBombDescription() {
		super(SmallBomb.src, "Grenade", "Cost: " + SmallBomb.cost, "Damage: " + SmallBomb.damage);
	}


	@Override
	public Bomb forge(Point point) {
		return new SmallBomb(point);
	}

}

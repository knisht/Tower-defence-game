package ui.description;

import core.Bomb;
import core.primitive.Point;
import types.bomb.BigBomb;
import ui.BuildDescription;

public class BigBombDescription extends BuildDescription<Bomb> {

	public BigBombDescription() {
		super(BigBomb.src, "Atomic bomb", "Cost: " + BigBomb.cost, "Damage: " + BigBomb.damage);
	}


	@Override
	public Bomb forge(Point point) {
		return new BigBomb(point);
	}

}

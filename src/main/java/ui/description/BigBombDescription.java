package ui.description;

import core.Bomb;
import types.bomb.BigBomb;
import ui.BuildDescription;

public class BigBombDescription extends BuildDescription<Bomb> {

	public BigBombDescription() {
		super(BigBomb.src, "Atomic bomb", "Cost: " + BigBomb.cost, "Damage: " + BigBomb.damage);
	}


	@Override
	public BigBomb forge(double x, double y) {
		return new BigBomb(x, y);
	}

}

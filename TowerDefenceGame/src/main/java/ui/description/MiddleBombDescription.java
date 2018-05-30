package ui.description;

import core.Bomb;
import types.bomb.MiddleBomb;
import ui.BuildDescription;

public class MiddleBombDescription extends BuildDescription<Bomb> {

	public MiddleBombDescription() {
		super(MiddleBomb.src, "Heat bomb", "Cost: " + MiddleBomb.cost, "Damage: " + MiddleBomb.damage);
	}


	@Override
	public MiddleBomb forge(double x, double y) {
		return new MiddleBomb(x, y);
	}

}

package ui.description;

import core.Bomb;
import core.primitive.Point;
import types.bomb.MiddleBomb;
import ui.BuildDescription;

public class MiddleBombDescription extends BuildDescription<Bomb> {

	public MiddleBombDescription() {
		super(MiddleBomb.src, "Heat bomb", "Cost: " + MiddleBomb.cost, "Damage: " + MiddleBomb.damage);
	}


	@Override
	public Bomb forge(Point point) {
		return new MiddleBomb(point);
	}

}

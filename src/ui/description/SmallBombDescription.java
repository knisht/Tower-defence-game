package ui.description;

import core.Bomb;
import types.bomb.SmallBomb;
import ui.BuildDescription;

public class SmallBombDescription extends BuildDescription<Bomb> {

	public SmallBombDescription() {
		super(SmallBomb.src, "Grenade", "Cost: " + SmallBomb.cost, "Damage: " + SmallBomb.damage);
	}


	@Override
	public SmallBomb forge(double x, double y) {
		return new SmallBomb(x, y);
	}

}
